package com.example.productionprojectfinal.Fragments.Enroll.EnrollDiscussion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Adapters.DiscussAdapter;
import com.example.productionprojectfinal.Adapters.EnrollDiscussAdapter;
import com.example.productionprojectfinal.Fragments.Discussion.AddDiscussionFragment;
import com.example.productionprojectfinal.Models.Discuss;
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


public class EnrollDiscussFragment extends Fragment {
    EnrollDiscussAdapter discussAdapter;
    RecyclerView recyclerView;
    String classid;


    public EnrollDiscussFragment() {
    }

    public EnrollDiscussFragment(String classid) {
        this.classid = classid;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enroll_discuss, container, false);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.adddiscussion);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String userid = user.getUid();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    String role = datas.child("role").getValue().toString();
                    //roleText.setText(role);
                    if (role.equals("Student")) {
                        floatingActionButton.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnrollDiscussAddFragment enrollDiscussAddFragment = new EnrollDiscussAddFragment(classid);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, enrollDiscussAddFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        recyclerView = view.findViewById(R.id.enrolldiscussrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("enrolldiscuss").child(classid);
        FirebaseRecyclerOptions<Discuss> options =
                new FirebaseRecyclerOptions.Builder<Discuss>()
                        .setQuery(ref, Discuss.class)
                        .build();

        discussAdapter = new EnrollDiscussAdapter(options);
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