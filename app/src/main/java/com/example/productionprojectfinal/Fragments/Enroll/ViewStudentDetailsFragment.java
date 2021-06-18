package com.example.productionprojectfinal.Fragments.Enroll;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Adapters.EnrollStudentsAdapter;
import com.example.productionprojectfinal.Adapters.UserAdapter;
import com.example.productionprojectfinal.Models.EnrollStudentsModel;
import com.example.productionprojectfinal.Models.Users;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewStudentDetailsFragment extends Fragment {
    EnrollStudentsAdapter enrollStudentsAdapter;
    String classid;
    public ViewStudentDetailsFragment() {
    }

    public ViewStudentDetailsFragment(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_view_student_details, container, false);

        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.classenrollsrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<EnrollStudentsModel> options =
                new FirebaseRecyclerOptions.Builder<EnrollStudentsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("classes").child("enrollments").child(classid), EnrollStudentsModel.class)
                        .build();

        enrollStudentsAdapter = new EnrollStudentsAdapter(options);
        recyclerView.setAdapter(enrollStudentsAdapter);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        enrollStudentsAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        enrollStudentsAdapter.stopListening();
    }
}