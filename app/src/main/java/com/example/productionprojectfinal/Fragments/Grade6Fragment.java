package com.example.productionprojectfinal.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Fragments.Grade6.G6EnglishFragment;
import com.example.productionprojectfinal.Fragments.Grade6.G6MathematicsFragment;
import com.example.productionprojectfinal.Fragments.Grade6.G6NepaliFragment;
import com.example.productionprojectfinal.Fragments.Grade6.G6ScienceFragment;
import com.example.productionprojectfinal.Fragments.Grade6.G6SocialFragment;
import com.example.productionprojectfinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Grade6Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Grade6Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Grade6Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Grade6Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Grade6Fragment newInstance(String param1, String param2) {
        Grade6Fragment fragment = new Grade6Fragment();
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
                G6ScienceFragment g6ScienceFragment = new G6ScienceFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, g6ScienceFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g6english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G6EnglishFragment g6EnglishFragment = new G6EnglishFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, g6EnglishFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g6social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G6SocialFragment g6SocialFragment = new G6SocialFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, g6SocialFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g6nepali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G6NepaliFragment g6NepaliFragment = new G6NepaliFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, g6NepaliFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        g6mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G6MathematicsFragment g6MathematicsFragment = new G6MathematicsFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, g6MathematicsFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}