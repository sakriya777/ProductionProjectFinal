package com.example.productionprojectfinal.Fragments.Enroll;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Fragments.Quiz.TeacherQuizFragmentScreen;
import com.example.productionprojectfinal.R;

public class EnrollTeacherDetails extends Fragment {

    String classid;
    public EnrollTeacherDetails() {
    }

    public EnrollTeacherDetails(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enroll_teacher_details, container, false);
        CardView studentdetail, quizdetail;

        studentdetail = view.findViewById(R.id.studentdetails);
        quizdetail = view.findViewById(R.id.quizdetails);

        studentdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new ViewStudentDetailsFragment(classid)).addToBackStack(null).commit();
            }
        });

        quizdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeacherQuizFragmentScreen(classid)).addToBackStack(null).commit();
            }
        });

        return view;
    }
}