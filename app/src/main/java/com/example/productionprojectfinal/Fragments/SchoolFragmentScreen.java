package com.example.productionprojectfinal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.productionprojectfinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SchoolFragmentScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SchoolFragmentScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button grade6,grade7,grade8,grade9,grade10,grade11,grade12;

    public SchoolFragmentScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SchoolFragmentScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static SchoolFragmentScreen newInstance(String param1, String param2) {
        SchoolFragmentScreen fragment = new SchoolFragmentScreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_school_screen, container, false);

        grade6 = v.findViewById(R.id.getgrade6);

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