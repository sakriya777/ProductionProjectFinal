package com.example.productionprojectfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstScreenFragment extends Fragment {

    CardView formalcardview, nonformalcardview;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstScreenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstScreenFragment newInstance(String param1, String param2) {
        FirstScreenFragment fragment = new FirstScreenFragment();
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
        View v = inflater.inflate(R.layout.fragment_first_screen, container, false);

        formalcardview = v.findViewById(R.id.formalcard);
        nonformalcardview = v.findViewById(R.id.nonformalcard);

        formalcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SchoolFragmentScreen schoolFragmentScreen = new SchoolFragmentScreen();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, schoolFragmentScreen);
                fragmentTransaction.commit();

            }
        });

        nonformalcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutSchoolFragmentScreen outSchoolFragmentScreen = new OutSchoolFragmentScreen();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, outSchoolFragmentScreen).addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);

            }
        });
    return v;
    }
}