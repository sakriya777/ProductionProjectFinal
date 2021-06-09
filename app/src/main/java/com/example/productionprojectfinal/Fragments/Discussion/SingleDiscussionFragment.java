package com.example.productionprojectfinal.Fragments.Discussion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productionprojectfinal.Adapters.CommentAdapter;
import com.example.productionprojectfinal.Models.Comment;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;


public class SingleDiscussionFragment extends Fragment {

    String fullname, about, discussion, key, postkey, title;
    String commenttxt;
    CommentAdapter commentAdapter;

    public SingleDiscussionFragment() {
        // Required empty public constructor
    }

    public SingleDiscussionFragment(String fullname, String about, String discussion, String key, String postkey,String title) {
        this.fullname = fullname;
        this.about = about;
        this.discussion = discussion;
        this.key = key;
        this.postkey = postkey;
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_discussion, container, false);
        TextView abouttxt, discusstxt, nametxt, titletxt;
        TextInputEditText comment;
        ImageView addcmtbtn;

        abouttxt = view.findViewById(R.id.abouttext);
        discusstxt = view.findViewById(R.id.discussiontext);
        nametxt = view.findViewById(R.id.discussionowner);
        comment = view.findViewById(R.id.addacommentbox);
        addcmtbtn = view.findViewById(R.id.addcommentbtn);
        titletxt = view.findViewById(R.id.titletext);

        nametxt.setText(fullname);
        discusstxt.setText(discussion);
        abouttxt.setText(about);
        titletxt.setText(title);

        Log.i("comment", "comment should be here");
        RecyclerView commentrecyclers;
        commentrecyclers = view.findViewById(R.id.commentrecycler);
        commentrecyclers.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Comment> options =
                new FirebaseRecyclerOptions.Builder<Comment>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("comment").child(postkey), Comment.class)
                        .build();

        commentAdapter = new CommentAdapter(options);

        commentrecyclers.setAdapter(commentAdapter);

        addcmtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commenttxt = comment.getText().toString();
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String commenterid = auth.getUid();
                FirebaseDatabase firebaseDatabase;
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                DatabaseReference dbref = reference.child("comment");


                HashMap<String, String> user = new HashMap<>();
                user.put("comment", commenttxt);
                user.put("commenterid", commenterid);
                user.put("postid", postkey);

                dbref.child(postkey)
                        .push()
                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        comment.setText("");
                        Toast.makeText(getContext(), "Comment Added", Toast.LENGTH_SHORT).show();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.detach(SingleDiscussionFragment.this).attach(SingleDiscussionFragment.this).commit();
                    }
                });
            }
        });




        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        commentAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        commentAdapter.stopListening();
    }
}