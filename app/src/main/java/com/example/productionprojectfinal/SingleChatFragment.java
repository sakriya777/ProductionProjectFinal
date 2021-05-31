package com.example.productionprojectfinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SingleChatFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    String fname;
    String lname;
    String uid;
    String email;
    public SingleChatFragment() {
    }

    public SingleChatFragment(String fname, String lname, String uid, String email) {
        this.fname = fname;
        this.lname = lname;
        this.uid = uid;
        this.email = email;
    }

    public static SingleChatFragment newInstance(String param1, String param2) {
        SingleChatFragment fragment = new SingleChatFragment();
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
        View view = inflater.inflate(R.layout.fragment_single_chat, container, false);

        TextView name = view.findViewById(R.id.name);

        name.setText(fname+" "+lname);

        return  view;
    }

    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new ChatFragmentScreen()).addToBackStack(null).commit();
    }


}
