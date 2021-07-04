package com.example.productionprojectfinal.Fragments.SchoolFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.productionprojectfinal.Activities.DataBulkAdd;
import com.example.productionprojectfinal.Fragments.SchoolFragments.Grade10Fragment;
import com.example.productionprojectfinal.Fragments.SchoolFragments.Grade11Fragment;
import com.example.productionprojectfinal.Fragments.SchoolFragments.Grade12Fragment;
import com.example.productionprojectfinal.Fragments.SchoolFragments.Grade6Fragment;
import com.example.productionprojectfinal.Fragments.SchoolFragments.Grade7Fragment;
import com.example.productionprojectfinal.Fragments.SchoolFragments.Grade8Fragment;
import com.example.productionprojectfinal.Fragments.SchoolFragments.Grade9Fragment;
import com.example.productionprojectfinal.R;


public class SchoolFragmentScreen extends Fragment {



    Button grade6,grade7,grade8,grade9,grade10,grade11,grade12;

    public SchoolFragmentScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_school_screen, container, false);


        grade6 = v.findViewById(R.id.getgrade6);

        Button  adddata;
        adddata = v.findViewById(R.id.add_data);
        adddata.setVisibility(View.GONE);
        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DataBulkAdd.class);
                startActivity(intent);
            }
        });

        grade6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade6Fragment grade6Fragment = new Grade6Fragment();
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.container, grade6Fragment).addToBackStack(null);
                fm.commit();
            }
        });
        grade7 = v.findViewById(R.id.getgrade7);

        grade7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade7Fragment grade7Fragment = new Grade7Fragment();
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.container, grade7Fragment).addToBackStack(null);
                fm.commit();
            }
        });
        grade8 = v.findViewById(R.id.getgrade8);

        grade8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade8Fragment grade8Fragment = new Grade8Fragment();
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.container, grade8Fragment).addToBackStack(null);
                fm.commit();
            }
        });
        grade9 = v.findViewById(R.id.getgrade9);

        grade9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade9Fragment grade9Fragment = new Grade9Fragment();
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.container, grade9Fragment).addToBackStack(null);
                fm.commit();
            }
        });
        grade10 = v.findViewById(R.id.getgrade10);

        grade10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade10Fragment grade10Fragment = new Grade10Fragment();
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.container, grade10Fragment).addToBackStack(null);
                fm.commit();
            }
        });
        grade11 = v.findViewById(R.id.getgrade11);

        grade11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade11Fragment grade11Fragment = new Grade11Fragment();
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.container, grade11Fragment).addToBackStack(null);
                fm.commit();
            }
        });
        grade12 = v.findViewById(R.id.getgrade12);

        grade12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade12Fragment grade12Fragment = new Grade12Fragment();
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.container, grade12Fragment).addToBackStack(null);
                fm.commit();
            }
        });

        return v;
    }
}