package com.example.productionprojectfinal.Fragments.Enroll;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.productionprojectfinal.Fragments.Quiz.QuizFragmentScreen;
import com.example.productionprojectfinal.Fragments.Quiz.TeacherQuizFragmentScreen;
import com.example.productionprojectfinal.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        CardView studentdetail, quizdetail, videocall, studentresult, upgradeclass, deleteclass;

        studentresult = view.findViewById(R.id.results);
        studentdetail = view.findViewById(R.id.studentdetails);
        quizdetail = view.findViewById(R.id.quizdetails);
        videocall = view.findViewById(R.id.videomeet);
        upgradeclass = view.findViewById(R.id.upgradeclass);
       //deleteclass = view.findViewById(R.id.deleteclass);

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

        studentresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new ViewStudentResultsFragment(classid)).addToBackStack(null).commit();
            }
        });

        upgradeclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                new AlertDialog.Builder(activity)
                        .setTitle("Confirmation")
                        .setMessage("Are you sure you want Upgrade the class")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(activity, "Upgrading", Toast.LENGTH_SHORT).show();
                                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new UpgradeClassTeacher(classid)).addToBackStack(null).commit();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(activity, "Not upgrading", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

//        deleteclass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                new AlertDialog.Builder(activity)
//                        .setTitle("Confirmation")
//                        .setMessage("Are you sure you want to delete the class? This cannot be undone")
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                Toast.makeText(activity, "Deleted", Toast.LENGTH_SHORT).show();
//                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//
//                            }
//                        })
//                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(activity, "Not Deleted", Toast.LENGTH_SHORT).show();
//                            }
//                        }).show();
//
//            }
//        });

        return view;
    }
}