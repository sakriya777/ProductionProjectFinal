package com.example.productionprojectfinal.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productionprojectfinal.Adapters.MessageAdapter;
import com.example.productionprojectfinal.Adapters.UserAdapter;
import com.example.productionprojectfinal.Models.Messages;
import com.example.productionprojectfinal.Models.Users;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;

public class SingleChatFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    String fname;
    String lname;
    String uid;
    String email;
    FirebaseAuth auth;
    String recieverUID, senderUID;
    FirebaseDatabase firebaseDatabase;
    String senderRoom, recieverRoom;
    ArrayList<Messages> messagesArraylist;
    MessageAdapter messageAdapter;
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

        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        TextView name = view.findViewById(R.id.name);
        EditText messageedittext = view.findViewById(R.id.edittextmessage);
        CardView sendbtn = view.findViewById(R.id.sendbtn);
        RecyclerView messagerecycler = view.findViewById(R.id.messagerecycler);

        messagesArraylist = new ArrayList<>();

        recieverUID = uid;
        senderUID = auth.getUid();

        senderRoom = senderUID+recieverUID;
        recieverRoom = recieverUID+senderUID;

        DatabaseReference reference = firebaseDatabase.getReference().child("users").child(senderUID);
        DatabaseReference chatReference = firebaseDatabase.getReference().child("chats").child(senderRoom).child("messages");

        messageAdapter = new MessageAdapter(getContext(), messagesArraylist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);

        messagerecycler.setLayoutManager(linearLayoutManager);

        messagerecycler.setAdapter(messageAdapter);

        chatReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                messagesArraylist.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Messages messages = dataSnapshot.getValue(Messages.class);
                    messagesArraylist.add(messages);
                }
                messageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        name.setText(fname+" "+lname);

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageedittext.getText().toString();
                if(message.isEmpty()){
                    Toast.makeText(container.getContext(), "Enter a Message", Toast.LENGTH_SHORT).show();
                }
                else{
                    messageedittext.setText("");
                    Date date = new Date();
                    Messages messages = new Messages(message, senderUID, date.getTime());

                    firebaseDatabase = FirebaseDatabase.getInstance();
                    firebaseDatabase.getReference().child("chats")
                            .child(senderRoom)
                            .child("messages")
                            .push()
                            .setValue(messages).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                            firebaseDatabase.getReference().child("chats")
                                    .child(recieverRoom)
                                    .child("messages")
                                    .push().setValue(messages).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {

                                }
                            });
                        }
                    });
                }
            }
        });

        return  view;
    }

    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new ChatFragmentScreen()).addToBackStack(null).commit();
    }


}
