package com.example.productionprojectfinal.Fragments.Enroll;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.productionprojectfinal.Adapters.ClassAdapter;
import com.example.productionprojectfinal.Adapters.DiscussAdapter;
import com.example.productionprojectfinal.Fragments.Discussion.AddDiscussionFragment;
import com.example.productionprojectfinal.Models.ClassModel;
import com.example.productionprojectfinal.Models.Discuss;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherEnrollFragmentScreen extends Fragment {

    ClassAdapter classAdapter;

    public TeacherEnrollFragmentScreen() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_enroll_screen, container, false);

        Button addclassbtn;

        addclassbtn = view.findViewById(R.id.addenroll);

        addclassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddEnrollFragment addEnrollFragment = new AddEnrollFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, addEnrollFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.classrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<ClassModel> options =
                new FirebaseRecyclerOptions.Builder<ClassModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("classes"), ClassModel.class)
                        .build();

        classAdapter = new ClassAdapter(options);
        recyclerView.setAdapter(classAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        classAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        classAdapter.stopListening();
    }
}