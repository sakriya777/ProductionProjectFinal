package com.example.productionprojectfinal.Fragments.Enroll;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.productionprojectfinal.Fragments.Quiz.QuizFragmentScreen;
import com.example.productionprojectfinal.Models.QuizModel;
import com.example.productionprojectfinal.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class VideoCallOrQuizFragment extends Fragment {

    String classid;
    public static ArrayList<QuizModel> listofquestions = new ArrayList<>();
    public VideoCallOrQuizFragment() {
    }

    public VideoCallOrQuizFragment(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_call_or_quiz, container, false);
        CardView videomeet, quiz;
        videomeet = view.findViewById(R.id.videomeeting);
        quiz = view.findViewById(R.id.quizstart);

        videomeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                            .setServerURL(new URL("https://meet.jit.si"))
                            .setRoom(classid)
                            .setAudioMuted(false)
                            .setVideoMuted(false)
                            .setAudioOnly(false)
                            .setWelcomePageEnabled(false)
                            .build();

                    JitsiMeetActivity.launch(getContext(), options);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference =  FirebaseDatabase.getInstance().getReference("classes").child("quiz").child(classid);

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                            QuizModel quizModel = dataSnapshot.getValue(QuizModel.class);
                            Log.i("working", dataSnapshot.getKey());

                            String questions = dataSnapshot.child("question").getValue().toString();
                            String options1 = dataSnapshot.child("option1").getValue().toString();
                            String options2 = dataSnapshot.child("option2").getValue().toString();
                            String options3 = dataSnapshot.child("option3").getValue().toString();
                            String options4 = dataSnapshot.child("option4").getValue().toString();
                            String answers = dataSnapshot.child("answer").getValue().toString();
                            listofquestions.add(new QuizModel(questions, options1, options2, options3, options4, answers));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                new AlertDialog.Builder(activity)
                        .setTitle("Confirmation")
                        .setMessage("You are About to start a Quiz Are you sure?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(activity, "Time starts Now", Toast.LENGTH_SHORT).show();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new QuizFragmentScreen(classid)).addToBackStack(null).commit();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(activity, "Nayy", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });


        return view;
    }
}