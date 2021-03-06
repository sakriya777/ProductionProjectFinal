package com.example.productionprojectfinal.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Fragments.Chat.SingleChatFragment;
import com.example.productionprojectfinal.Models.Users;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class UserAdapter extends FirebaseRecyclerAdapter<Users, UserAdapter.myViewHolder> {

    public UserAdapter(@NonNull @NotNull FirebaseRecyclerOptions<Users> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull Users model) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String currentuser = auth.getCurrentUser().getUid();

        holder.name.setText(model.getFname() + " " + model.getLname());
        holder.role.setText(model.getRole());

        if (currentuser.equals(model.getUID())){
            holder.chatone.setVisibility(View.GONE);
            holder.chatone.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }

        holder.chatone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new SingleChatFragment(model.getFname(), model.getLname(), model.getUID(), model.getEmail())).addToBackStack(null).commit();
            }
        });

    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_user_single, parent, false);

        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, role;
        CardView chatone;
        RecyclerView recyclerView;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            role = itemView.findViewById(R.id.userrole);
            name = itemView.findViewById(R.id.username);
            chatone = itemView.findViewById(R.id.chatone);
            recyclerView = itemView.findViewById(R.id.chatrecycler);
        }
    }

}