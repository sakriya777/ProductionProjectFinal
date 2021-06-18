package com.example.productionprojectfinal.Fragments.Quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
}