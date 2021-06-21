package com.example.productionprojectfinal.Fragments.Enroll;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Adapters.ClassAdapter;
import com.example.productionprojectfinal.Adapters.EnrollStudentsAdapter;
import com.example.productionprojectfinal.Adapters.StudentViewEnrollAdapter;
import com.example.productionprojectfinal.Fragments.Chat.SingleChatFragment;
import com.example.productionprojectfinal.Models.ClassModel;
import com.example.productionprojectfinal.Models.EnrollStudentsModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class EnrollFragmentScreen extends Fragment {

    StudentViewEnrollAdapter studentViewEnrollAdapter;

    public EnrollFragmentScreen() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enroll_screen, container, false);

        RecyclerView recyclerView;
        FloatingActionButton enroll = view.findViewById(R.id.enrollinaclass);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new EnrollClassEnterCredentials()).addToBackStack(null).commit();
            }
        });

        recyclerView = view.findViewById(R.id.studentenrolledrecycled);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<EnrollStudentsModel> options =
                new FirebaseRecyclerOptions.Builder<EnrollStudentsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("enrollments").child(uid), EnrollStudentsModel.class)
                        .build();

        studentViewEnrollAdapter = new StudentViewEnrollAdapter(options);
        recyclerView.setAdapter(studentViewEnrollAdapter);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        studentViewEnrollAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        studentViewEnrollAdapter.stopListening();
    }
}