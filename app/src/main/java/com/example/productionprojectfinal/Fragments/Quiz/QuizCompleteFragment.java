package com.example.productionprojectfinal.Fragments.Quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productionprojectfinal.Fragments.Enroll.VideoCallOrQuizFragment;
import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;


public class QuizCompleteFragment extends Fragment {
    int correctans, incorrectans, totalquestions;
    String classid;
    public QuizCompleteFragment() {
    }

    public QuizCompleteFragment(int correctans, int incorrectans, int totalquestions, String classid) {
        this.correctans = correctans;
        this.incorrectans = incorrectans;
        this.totalquestions = totalquestions;
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_complete, container, false);

        TextView text = view.findViewById(R.id.score);
        Button goback = view.findViewById(R.id.goback);

        text.setText(correctans+"/"+totalquestions);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        HashMap<String, String> results = new HashMap<>();

        results.put("correct", ""+correctans);
        results.put("incorrect", ""+incorrectans);
        results.put("total", ""+totalquestions);
        results.put("uid", uid);
        results.put("classid", classid);

        DatabaseReference databaseReference;

        databaseReference = FirebaseDatabase.getInstance().getReference().child("classes").child("results");

        databaseReference.child(classid).push().setValue(results).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {
                Toast.makeText(getContext(), "Results Uploaded", Toast.LENGTH_SHORT).show();
            }
        });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new VideoCallOrQuizFragment(classid)).addToBackStack(null).commit();
            }
        });

        return  view;
    }
}