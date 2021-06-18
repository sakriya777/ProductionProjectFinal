package com.example.productionprojectfinal.Fragments.OutSchool;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.productionprojectfinal.Activities.AddOutSchoolCourse;
import com.example.productionprojectfinal.Adapters.CourseAdapter;
import com.example.productionprojectfinal.Adapters.VideoAdapter;
import com.example.productionprojectfinal.Models.CourseModel;
import com.example.productionprojectfinal.Models.VideoModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;


public class OutSchoolFragmentScreen extends Fragment {
    String role;
    VideoAdapter videoAdapter;

    public OutSchoolFragmentScreen() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_out_school_screen, container, false);

        RecyclerView videoRecycler = view.findViewById(R.id.outcourserecycler);

        videoRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<VideoModel> options =
                new FirebaseRecyclerOptions.Builder<VideoModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("videos"), VideoModel.class)
                        .build();

        videoAdapter = new VideoAdapter(options);
        videoRecycler.setAdapter(videoAdapter);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FloatingActionButton addCourse = view.findViewById(R.id.add_out_courses);
        String userid = user.getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    role = datas.child("role").getValue().toString();

                    if (role.equals("Freelancer") || role.equals("Teacher")) {
                        addCourse.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               Intent intent = new Intent(getContext(), AddOutSchoolCourse.class);
                               startActivity(intent);
                            }
                        });
                    } else {
                        addCourse.setVisibility(View.GONE);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        videoAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        videoAdapter.stopListening();
    }
}