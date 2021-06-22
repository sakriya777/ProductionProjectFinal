package com.example.productionprojectfinal.Fragments.SchoolFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Adapters.CourseAdapter;
import com.example.productionprojectfinal.Adapters.LessonAdapter;
import com.example.productionprojectfinal.Models.CourseModel;
import com.example.productionprojectfinal.Models.LessonModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class LessonFragment extends Fragment {

    String names;
    String number;
    String chap;
    String grade;
    String subject;

    LessonAdapter lessonAdapter;
    CourseAdapter courseAdapter;
    public LessonFragment() {
    }

    public LessonFragment(String names, String number, String chap, String grade, String subject) {
        this.names = names;
        this.chap = chap;
        this.number = number;
        this.grade = grade;
        this.subject = subject;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.lessonrecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<LessonModel> options =
                new FirebaseRecyclerOptions.Builder<LessonModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("schoolcourse").child(grade).child(subject).child(chap+"lesson"), LessonModel.class)
                        .build();

        lessonAdapter = new LessonAdapter(options);
        recyclerView.setAdapter(lessonAdapter);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        lessonAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        lessonAdapter.stopListening();
    }
}