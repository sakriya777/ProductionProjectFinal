package com.example.productionprojectfinal.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.productionprojectfinal.AddOutSchoolCourse;
import com.example.productionprojectfinal.R;
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


    public OutSchoolFragmentScreen() {
    }

    String role;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_out_school_screen, container, false);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FloatingActionButton addCourse = view.findViewById(R.id.add_out_course);
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
                               startActivity(new Intent(getContext(), AddOutSchoolCourse.class));
                            }
                        });
                    } else if (role.equals("Student")) {
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
}