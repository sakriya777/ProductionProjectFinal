package com.example.productionprojectfinal.Fragments.Quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productionprojectfinal.Fragments.Enroll.TeacherEnrollFragmentScreen;
import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class AddQuizFragment extends Fragment {

    String classid;
    public AddQuizFragment() {
    }

    public AddQuizFragment(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_quiz, container, false);

        TextView classidview;
        TextInputEditText questions, options1, options2, options3, options4;
        Button addquestion, addquiz;
        classidview = view.findViewById(R.id.classidquiz);
        classidview.setText("Class ID: " + classid);


        questions = view.findViewById(R.id.question);
        options1 = view.findViewById(R.id.opt1);
        options2 = view.findViewById(R.id.opt2);
        options3 = view.findViewById(R.id.opt3);
        options4 = view.findViewById(R.id.opt4);

        addquestion = view.findViewById(R.id.addquestion);
        addquiz = view.findViewById(R.id.finishquiz);


        addquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = questions.getText().toString();
                String option1 = options1.getText().toString();
                String option2 = options2.getText().toString();
                String option3 = options3.getText().toString();
                String option4 = options4.getText().toString();

                if (question.isEmpty() |option1.isEmpty() |option2.isEmpty() |option3.isEmpty() |option4.isEmpty()){
                    Toast.makeText(getActivity(), "Enter All the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    HashMap<String, String> questionmap = new HashMap<>();

                    questionmap.put("question", question);
                    questionmap.put("option1", option1);
                    questionmap.put("option2", option2);
                    questionmap.put("option3", option3);
                    questionmap.put("option4", option4);

                    DatabaseReference databaseReference;

                    databaseReference = FirebaseDatabase.getInstance().getReference().child("classes").child("quiz");

                    databaseReference.child(classid).push().setValue(questionmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Question Added", Toast.LENGTH_SHORT).show();
                                questions.setText("");
                                options1.setText("");
                                options2.setText("");
                                options3.setText("");
                                options4.setText("");

                            } else {
                                Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        addquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherQuizFragmentScreen teacherQuizFragmentScreen = new TeacherQuizFragmentScreen(classid);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, teacherQuizFragmentScreen);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}