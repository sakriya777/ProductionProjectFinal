package com.example.productionprojectfinal.Fragments.SchoolFragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Fragments.GradeChaptersFragment;
import com.example.productionprojectfinal.R;


public class Grade9Fragment extends Fragment {


    public Grade9Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade9, container, false);

        CardView g9science, g9english, g9social, g9nepali, g9mathematics;

        g9science = view.findViewById(R.id.g9sciencebtn);
        g9english = view.findViewById(R.id.g9englishbtn);
        g9social = view.findViewById(R.id.g9socialbtn);
        g9nepali = view.findViewById(R.id.g9nepalibtn);
        g9mathematics = view.findViewById(R.id.g9mathematicsbtn);

        String grade = "grade9";

        g9science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "science");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g9english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "english");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g9social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "social");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g9nepali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "nepali");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g9mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "mathematics");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}