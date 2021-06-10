package com.example.productionprojectfinal.Fragments.SchoolFragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.R;

public class Grade10Fragment extends Fragment {


    public Grade10Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade10, container, false);

        CardView g10science, g10english, g10social, g10nepali, g10mathematics;

        g10science = view.findViewById(R.id.g10sciencebtn);
        g10english = view.findViewById(R.id.g10englishbtn);
        g10social = view.findViewById(R.id.g10socialbtn);
        g10nepali = view.findViewById(R.id.g10nepalibtn);
        g10mathematics = view.findViewById(R.id.g10mathematicsbtn);

        String grade = "grade10";

        g10science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "science");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g10english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "english");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g10social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "social");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g10nepali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "nepali");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g10mathematics.setOnClickListener(new View.OnClickListener() {
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