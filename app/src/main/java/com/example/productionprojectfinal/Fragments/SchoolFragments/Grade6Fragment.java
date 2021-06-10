package com.example.productionprojectfinal.Fragments.SchoolFragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.R;

public class Grade6Fragment extends Fragment {


    public Grade6Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade6, container, false);

        CardView g6science, g6english, g6social, g6nepali, g6mathematics;

        g6science = view.findViewById(R.id.g6sciencebtn);
        g6english = view.findViewById(R.id.g6englishbtn);
        g6social = view.findViewById(R.id.g6socialbtn);
        g6nepali = view.findViewById(R.id.g6nepalibtn);
        g6mathematics = view.findViewById(R.id.g6mathematicsbtn);

        g6science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment("grade6", "science");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g6english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment("grade6", "english");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g6social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment("grade6", "social");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g6nepali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment("grade6", "nepali");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g6mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment("grade6", "mathematics");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}