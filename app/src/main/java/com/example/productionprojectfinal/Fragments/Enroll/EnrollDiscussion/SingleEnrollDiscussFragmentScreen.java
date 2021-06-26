package com.example.productionprojectfinal.Fragments.Enroll.EnrollDiscussion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.R;

public class SingleEnrollDiscussFragmentScreen extends Fragment {

    public SingleEnrollDiscussFragmentScreen() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_single_enroll_discuss_screen, container, false);
    }
}