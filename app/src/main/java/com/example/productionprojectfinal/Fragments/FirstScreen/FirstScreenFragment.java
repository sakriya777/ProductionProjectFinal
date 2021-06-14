package com.example.productionprojectfinal.Fragments.FirstScreen;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Fragments.OutSchool.OutSchoolFragmentScreen;
import com.example.productionprojectfinal.Fragments.SchoolFragments.SchoolFragmentScreen;
import com.example.productionprojectfinal.R;


public class FirstScreenFragment extends Fragment {

    CardView formalcardview, nonformalcardview;
    String role;

    public FirstScreenFragment() {
        // Required empty public constructor
    }

    public FirstScreenFragment(String role) {
        this.role = role;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first_screen, container, false);

        formalcardview = v.findViewById(R.id.formalcard);
        nonformalcardview = v.findViewById(R.id.nonformalcard);

        formalcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SchoolFragmentScreen schoolFragmentScreen = new SchoolFragmentScreen();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, schoolFragmentScreen).addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        nonformalcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, new OutSchoolFragmentScreen()).addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);

            }
        });
    return v;
    }
}