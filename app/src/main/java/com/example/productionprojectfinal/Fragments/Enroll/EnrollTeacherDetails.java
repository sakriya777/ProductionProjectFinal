package com.example.productionprojectfinal.Fragments.Enroll;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productionprojectfinal.Fragments.Quiz.TeacherQuizFragmentScreen;
import com.example.productionprojectfinal.R;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class EnrollTeacherDetails extends Fragment {

    String classid;
    public EnrollTeacherDetails() {
    }

    public EnrollTeacherDetails(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enroll_teacher_details, container, false);
        CardView studentdetail, quizdetail, videocall;

        studentdetail = view.findViewById(R.id.studentdetails);
        quizdetail = view.findViewById(R.id.quizdetails);
        videocall = view.findViewById(R.id.videomeet);

        studentdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new ViewStudentDetailsFragment(classid)).addToBackStack(null).commit();
            }
        });

        quizdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeacherQuizFragmentScreen(classid)).addToBackStack(null).commit();
            }
        });

        videocall.setOnClickListener(new View.OnClickListener() {
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

        return view;
    }
}