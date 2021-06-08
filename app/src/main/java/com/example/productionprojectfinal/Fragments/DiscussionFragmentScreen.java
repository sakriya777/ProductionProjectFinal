package com.example.productionprojectfinal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Adapters.DiscussAdapter;
import com.example.productionprojectfinal.Adapters.UserAdapter;
import com.example.productionprojectfinal.Models.Discuss;
import com.example.productionprojectfinal.Models.Users;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class DiscussionFragmentScreen extends Fragment {

    DiscussAdapter discussAdapter;
    RecyclerView recyclerView;

    public DiscussionFragmentScreen() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discussion_screen, container, false);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.adddiscussion);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDiscussionFragment addDiscussionFragment = new AddDiscussionFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, addDiscussionFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        recyclerView = view.findViewById(R.id.discussrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Discuss> options =
                new FirebaseRecyclerOptions.Builder<Discuss>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("discuss"), Discuss.class)
                .build();

        discussAdapter = new DiscussAdapter(options);
        recyclerView.setAdapter(discussAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        discussAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        discussAdapter.stopListening();
    }
}