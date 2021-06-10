package com.example.productionprojectfinal.Fragments.SchoolFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.productionprojectfinal.R;

public class SingleLessonFragment extends Fragment {

    String names, number, contenta, lesson;

    public SingleLessonFragment() {
    }

    public SingleLessonFragment(String names, String number, String content, String lesson) {
        this.names = names;
        this.number = number;
        this.contenta = content;
        this.lesson = lesson;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_lesson, container, false);

        TextView title, content;

        title = view.findViewById(R.id.titles);
        content = view.findViewById(R.id.contents);

        title.setText(names);

        content.setText(contenta);

        return view;
    }
}