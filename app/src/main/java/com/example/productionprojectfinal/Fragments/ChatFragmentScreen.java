package com.example.productionprojectfinal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.R;
import com.example.productionprojectfinal.Adapters.UserAdapter;
import com.example.productionprojectfinal.Models.Users;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatFragmentScreen extends Fragment {

    FirebaseAuth auth;
    RecyclerView recyclerView;
    UserAdapter userAdapter;

    FirebaseDatabase firebaseDatabase;

    ArrayList<Users> usersArrayList;

    public ChatFragmentScreen() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chat_screen, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.chatrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Users> options =
                new FirebaseRecyclerOptions.Builder<Users>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users"), Users.class)
                        .build();


        userAdapter = new UserAdapter(options);
        recyclerView.setAdapter(userAdapter);

        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        userAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        userAdapter.stopListening();
    }

}