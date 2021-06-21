package com.example.productionprojectfinal.Fragments.Quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.R;


public class QuizCompleteFragment extends Fragment {
    int correctans, incorrectans;
    public QuizCompleteFragment() {
    }

    public QuizCompleteFragment(int correctans, int incorrectans) {
        this.correctans = correctans;
        this.incorrectans = incorrectans;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_complete, container, false);



        return  view;
    }
}