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

public class
Grade7Fragment extends Fragment {


    public Grade7Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade7, container, false);

        CardView g7science, g7english, g7social, g7nepali, g7mathematics;

        g7science = view.findViewById(R.id.g7sciencebtn);
        g7english = view.findViewById(R.id.g7englishbtn);
        g7social = view.findViewById(R.id.g7socialbtn);
        g7nepali = view.findViewById(R.id.g7nepalibtn);
        g7mathematics = view.findViewById(R.id.g7mathematicsbtn);

        String grade = "grade7";

        g7science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "science");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g7english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "english");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g7social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "social");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g7nepali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradeChaptersFragment gradeChaptersFragment = new GradeChaptersFragment(grade, "nepali");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, gradeChaptersFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g7mathematics.setOnClickListener(new View.OnClickListener() {
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