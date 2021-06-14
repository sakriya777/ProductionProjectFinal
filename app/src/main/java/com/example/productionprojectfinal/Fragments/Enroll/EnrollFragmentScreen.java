package com.example.productionprojectfinal.Fragments.Enroll;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.R;

public class EnrollFragmentScreen extends Fragment {



    public EnrollFragmentScreen() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enroll_screen, container, false);
    }
}