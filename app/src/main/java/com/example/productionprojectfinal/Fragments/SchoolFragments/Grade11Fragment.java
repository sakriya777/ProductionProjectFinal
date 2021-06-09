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

public class Grade11Fragment extends Fragment {


    public Grade11Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade11, container, false);

        CardView g11science, g11english, g11social, g11nepali, g11mathematics;

        g11science = view.findViewById(R.id.g11sciencebtn);
        g11english = view.findViewById(R.id.g11englishbtn);
        g11social = view.findViewById(R.id.g11socialbtn);
        g11nepali = view.findViewById(R.id.g11nepalibtn);
        g11mathematics = view.findViewById(R.id.g11mathematicsbtn);

        String grade = "grade11";

        g11science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "science");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g11english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "english");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g11social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "social");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g11nepali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "nepali");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g11mathematics.setOnClickListener(new View.OnClickListener() {
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