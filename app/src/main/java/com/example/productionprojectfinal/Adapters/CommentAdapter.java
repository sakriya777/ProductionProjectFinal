package com.example.productionprojectfinal.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Models.Comment;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class CommentAdapter extends FirebaseRecyclerAdapter<Comment, CommentAdapter.myViewHolder> {
    public CommentAdapter(FirebaseRecyclerOptions<Comment> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull Comment model) {

        String commenterid = model.getCommenterid();
        String comment = model.getComment();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(commenterid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    String fname;
                    String lname;
                    String fullname;
                    fname = datas.child("fname").getValue().toString();
                    lname = datas.child("lname").getValue().toString();
                    fullname = fname + " " + lname;
                    holder.comment.setText(comment);
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_single, parent, false);

        return new CommentAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, comment;

        public myViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.commentowner);
            comment = itemView.findViewById(R.id.commenttext);
        }
    }
}
