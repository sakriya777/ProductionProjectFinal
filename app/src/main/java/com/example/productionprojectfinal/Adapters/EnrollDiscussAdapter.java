package com.example.productionprojectfinal.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Fragments.Discussion.SingleDiscussionFragment;
import com.example.productionprojectfinal.Fragments.Enroll.EnrollDiscussion.SingleEnrollDiscussFragmentScreen;
import com.example.productionprojectfinal.Models.Discuss;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class EnrollDiscussAdapter extends FirebaseRecyclerAdapter<Discuss, EnrollDiscussAdapter.myViewHolder> {


    public EnrollDiscussAdapter(@NonNull @NotNull FirebaseRecyclerOptions<Discuss> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull Discuss model) {

        String id = model.getId();

        String postkey = model.getPostid();

        holder.about.setText(model.getAbout());
        holder.discussion.setText(model.getDiscuss());
        holder.title.setText(model.getTitle());

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot datas: snapshot.getChildren()){
                    String fname;
                    String lname;
                    String fullname;
                    fname = datas.child("fname").getValue().toString();
                    lname = datas.child("lname").getValue().toString();
                    fullname = fname+" "+lname;
                    holder.name.setText(fullname);
                    holder.role.setText(datas.child("role").getValue().toString());
                    holder.discussone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AppCompatActivity activity = (AppCompatActivity) v.getContext();
                            activity.getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.container, new SingleEnrollDiscussFragmentScreen(fullname, model.getAbout(), model.getDiscuss(), model.getKey(), postkey, model.getTitle())).addToBackStack(null).commit();
                        }
                    });
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discussion_single, parent, false);

        return new EnrollDiscussAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, about, discussion, title, role;

        CardView discussone;
        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.username);
            about = itemView.findViewById(R.id.abouttext);
            title = itemView.findViewById(R.id.titletext);
            discussion = itemView.findViewById(R.id.discussiontext);
            role = itemView.findViewById(R.id.disscusserrole);

            discussone = itemView.findViewById(R.id.discussone);

        }
    }

}
