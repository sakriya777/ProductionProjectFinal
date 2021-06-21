package com.example.productionprojectfinal.Fragments.Quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.productionprojectfinal.Adapters.QuizAdapter;
import com.example.productionprojectfinal.Models.QuizModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherQuizFragmentScreen extends Fragment {

    QuizAdapter quizAdapter;
    String classid;
    public TeacherQuizFragmentScreen() {
    }

    public TeacherQuizFragmentScreen(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_quiz_screen, container, false);

        RecyclerView recyclerView;
        Button addquiz, removeallquestions;

        recyclerView = view.findViewById(R.id.quizrecycler);
        addquiz = view.findViewById(R.id.addquizbtn);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("classes").child("quiz");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<QuizModel> options =
                new FirebaseRecyclerOptions.Builder<QuizModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("classes").child("quiz").child(classid), QuizModel.class)
                        .build();

        quizAdapter = new QuizAdapter(options);
        recyclerView.setAdapter(quizAdapter);

        addquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddQuizFragment addQuizFragment = new AddQuizFragment(classid);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, addQuizFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        removeallquestions = view.findViewById(R.id.removeallquestions);
        removeallquestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child(classid).removeValue();
            }
        });

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