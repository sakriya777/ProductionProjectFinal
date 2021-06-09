package com.example.productionprojectfinal.Fragments.Grade6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Adapters.CourseAdapter;
import com.example.productionprojectfinal.Models.CourseModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class G6MathematicsFragment extends Fragment {

    CourseAdapter courseAdapter;

    public G6MathematicsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_g6_mathematics, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.g6mathematicsrecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<CourseModel> options =
                new FirebaseRecyclerOptions.Builder<CourseModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("schoolcourse").child("grade6").child("mathematics"), CourseModel.class)
                        .build();

        courseAdapter = new CourseAdapter(options);
        recyclerView.setAdapter(courseAdapter);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        courseAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        courseAdapter.stopListening();
    }
}