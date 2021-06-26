package com.example.productionprojectfinal.Fragments.Enroll.EnrollDiscussion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.productionprojectfinal.Fragments.Discussion.DiscussionFragmentScreen;
import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class EnrollDiscussAddFragment extends Fragment {

    String classid;
    public EnrollDiscussAddFragment() {
    }

    public EnrollDiscussAddFragment(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enroll_discuss_add, container, false);
        TextInputEditText titlea, discussa, about;

        Button addDiscussion = view.findViewById(R.id.adddiscussbtn);
        titlea = view.findViewById(R.id.edittitle);
        discussa = view.findViewById(R.id.editdiscuss);
        about = view.findViewById(R.id.spinner);


        addDiscussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titletxt = titlea.getText().toString();
                String discusstxt = discussa.getText().toString();
                String abouttxt = about.getText().toString();

                DatabaseReference refrence = FirebaseDatabase.getInstance().getReference();

                FirebaseAuth auth = FirebaseAuth.getInstance();
                DatabaseReference dbref = refrence.child("enrolldiscuss");
                String id = auth.getUid();
                String postid = dbref.push().getKey();


                HashMap<String, String> user = new HashMap<>();
                user.put("about", abouttxt);
                user.put("title", titletxt);
                user.put("discuss", discusstxt);
                user.put("id", id);
                user.put("postid", postid);

                dbref.child(classid).child(postid)
                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        EnrollDiscussFragment enrollDiscussFragment = new EnrollDiscussFragment(classid);
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, enrollDiscussFragment);
                        fragmentTransaction.commit();
                    }

                });
            }
        });
        return view;
    }
}