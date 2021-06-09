package com.example.productionprojectfinal.Fragments.Discussion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class AddDiscussionFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddDiscussionFragment() {
    }

    public static AddDiscussionFragment newInstance(String param1, String param2) {
        AddDiscussionFragment fragment = new AddDiscussionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add_discussion, container, false);

        Spinner spinner = view.findViewById(R.id.spinner);
        TextInputEditText titlea, discussa;

        Button addDiscussion = view.findViewById(R.id.adddiscussbtn);
        titlea = view.findViewById(R.id.edittitle);
        discussa = view.findViewById(R.id.editdiscuss);

        final String[] paths = {"Social", "Science", "Mathematics", "Biology", "History"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final String[] about = new String[1];



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                about[0] = spinner.getSelectedItem().toString();
                Toast.makeText(getContext(), about[0],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addDiscussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titletxt = titlea.getText().toString();
                String discusstxt = discussa.getText().toString();

                DatabaseReference refrence = FirebaseDatabase.getInstance().getReference();

                FirebaseAuth auth = FirebaseAuth.getInstance();
                DatabaseReference dbref = refrence.child("discuss");
                String id = auth.getUid();
                String postid = dbref.push().getKey();


                HashMap<String, String> user = new HashMap<>();
                user.put("about", about[0]);
                user.put("title", titletxt);
                user.put("discuss", discusstxt);
                user.put("id",id);
                user.put("postid", postid);

                dbref.child(postid)
                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        DiscussionFragmentScreen discussionFragmentScreen = new DiscussionFragmentScreen();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, discussionFragmentScreen);
                        fragmentTransaction.commit();
                    }

                });
            }
        });
        return view;
    }
}