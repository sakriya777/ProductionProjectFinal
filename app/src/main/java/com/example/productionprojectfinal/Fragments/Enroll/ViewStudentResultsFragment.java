package com.example.productionprojectfinal.Fragments.Enroll;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Adapters.EnrollStudentsAdapter;
import com.example.productionprojectfinal.Adapters.StudentsResultAdapter;
import com.example.productionprojectfinal.Models.EnrollStudentsModel;
import com.example.productionprojectfinal.Models.ResultModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewStudentResultsFragment extends Fragment {
    String classid;
    StudentsResultAdapter studentsResultAdapter;
    public ViewStudentResultsFragment() {
    }

    public ViewStudentResultsFragment(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view =  inflater.inflate(R.layout.fragment_view_student_results, container, false);

            RecyclerView recyclerView;
            recyclerView = view.findViewById(R.id.resultsrecycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            FirebaseRecyclerOptions<ResultModel> options =
                    new FirebaseRecyclerOptions.Builder<ResultModel>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("classes").child("results").child(classid), ResultModel.class)
                            .build();

            studentsResultAdapter = new StudentsResultAdapter(options);
            recyclerView.setAdapter(studentsResultAdapter);

            return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        studentsResultAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        studentsResultAdapter.stopListening();
    }
}