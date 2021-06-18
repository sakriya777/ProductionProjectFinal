package com.example.productionprojectfinal.Fragments.Enroll;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.productionprojectfinal.Fragments.Quiz.QuizFragmentScreen;
import com.example.productionprojectfinal.R;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class VideoCallOrQuizFragment extends Fragment {

    String classid;

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