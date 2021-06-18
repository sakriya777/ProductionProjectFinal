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
import com.example.productionprojectfinal.Models.EnrollStudentsModel;
import com.example.productionprojectfinal.Models.Users;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class EnrollStudentsAdapter extends FirebaseRecyclerAdapter<EnrollStudentsModel, EnrollStudentsAdapter.myViewHolder> {

    public EnrollStudentsAdapter(@NonNull @NotNull FirebaseRecyclerOptions<EnrollStudentsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull EnrollStudentsModel model) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(model.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    String fname;
                    String lname;
                    String fullname;
                    fname = datas.child("fname").getValue().toString();
                    lname = datas.child("lname").getValue().toString();
                    fullname = fname + " " + lname;
                    holder.name.setText(fullname);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

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
        TextView name;
        CardView chatone;
        RecyclerView recyclerView;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.username);
            chatone = itemView.findViewById(R.id.chatone);
            recyclerView = itemView.findViewById(R.id.chatrecycler);
        }
    }

}