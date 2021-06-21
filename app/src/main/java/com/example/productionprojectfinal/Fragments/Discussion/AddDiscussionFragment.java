package com.example.productionprojectfinal.Fragments.Discussion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class AddDiscussionFragment extends Fragment {

    public AddDiscussionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add_discussion, container, false);

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
                DatabaseReference dbref = refrence.child("discuss");
                String id = auth.getUid();
                String postid = dbref.push().getKey();


                HashMap<String, String> user = new HashMap<>();
                user.put("about", abouttxt);
                user.put("title", titletxt);
                user.put("discuss", discusstxt);
                user.put("id",id);
                user.put("postid", postid);

                dbref.child(postid)
                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        DiscussionFragmentScreen discussionFragmentScreen = new DiscussionFragmentScreen();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, discussionFragmentScreen);
                        fragmentTransaction.commit();
                    }

                });
            }
        });
        return view;
    }
}