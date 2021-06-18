package com.example.productionprojectfinal.Fragments.Quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productionprojectfinal.Adapters.QuizAdapter;
import com.example.productionprojectfinal.Fragments.Enroll.EnrollFragmentScreen;
import com.example.productionprojectfinal.Models.QuizModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuizFragmentScreen extends Fragment {

    QuizAdapter quizAdapter;
    String classid;
    RecyclerView recyclerView;
    public QuizFragmentScreen() {
    }

    public QuizFragmentScreen(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_screen, container, false);

        TextView timer = view.findViewById(R.id.timer);

        reverseTimer(600, timer);

        recyclerView = view.findViewById(R.id.studentquizrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<QuizModel> options =
                new FirebaseRecyclerOptions.Builder<QuizModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("classes").child("quiz").child(classid), QuizModel.class)
                        .build();
        quizAdapter = new QuizAdapter(options);
        recyclerView.setAdapter(quizAdapter);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        quizAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        quizAdapter.stopListening();
    }
    public void reverseTimer(int Seconds,final TextView tv){

        new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText("TIME : " + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Completed");
            }
        }.start();
    }
}