package com.example.productionprojectfinal.Fragments.Quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productionprojectfinal.Models.QuizModel;
import com.example.productionprojectfinal.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.productionprojectfinal.Fragments.Enroll.VideoCallOrQuizFragment.listofquestions;

public class QuizFragmentScreen extends Fragment {

    String classid;
    List<QuizModel> quesans;
    QuizModel quizModelClass;
    TextView question;
    RadioGroup options;
    RadioButton option1, option2, option3, option4;
    Button nextquestion, completequiz;
    int checked = 0, correctans = 0, incorrectans = 0, index = 0;

    public QuizFragmentScreen() {
    }

    public QuizFragmentScreen(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_screen, container, false);

        question = view.findViewById(R.id.quesstudent);
        options = view.findViewById(R.id.optionsgroup);

        option1 = view.findViewById(R.id.singleopt1);
        option2 = view.findViewById(R.id.singleopt2);
        option3 = view.findViewById(R.id.singleopt3);
        option4 = view.findViewById(R.id.singleopt4);

        nextquestion = view.findViewById(R.id.nextquestion);
        completequiz = view.findViewById(R.id.completequiz);

        TextView timer = view.findViewById(R.id.timer);

        reverseTimer(600, timer);

        Log.i("size aray", "" + listofquestions.size());

        quesans = listofquestions;
        quizModelClass = quesans.get(index);

        SetAllData();

        nextquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                if (options.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getContext(), "Select answer First", Toast.LENGTH_SHORT).show();
                } else {
                    checked = options.getCheckedRadioButtonId();
                    RadioButton rb = view.findViewById(checked);
                    String rol = rb.getText().toString();
                    if (rol.equals(quizModelClass.getAnswer())) {
                        correctans = correctans + 1;
                        if (index < listofquestions.size() - 1) {
                            index = index + 1;
                            quizModelClass = quesans.get(index);
                            options.clearCheck();
                            SetAllData();
                        } else {
                            //quiz complete
                            //Toast.makeText(getContext(), "Corrext:" + correctans + "Incorrect" + incorrectans, Toast.LENGTH_SHORT).show();
                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new QuizCompleteFragment(correctans, incorrectans)).addToBackStack(null).commit();

                        }
                    } else {
                        incorrectans = incorrectans + 1;
                        if (index < listofquestions.size() - 1) {
                            index = index + 1;
                            quizModelClass = quesans.get(index);
                            options.clearCheck();
                            SetAllData();
                        } else {
                            //quiz complete
                            Toast.makeText(getContext(), "Corrext:" + correctans + "Incorrect" + incorrectans, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        return view;
    }

    private void SetAllData() {

        Random r = new Random();
        int i = r.nextInt(4 - 1) + 1;
        question.setText(quizModelClass.getQuestion());

        if (i == 1) {
            option1.setText(quizModelClass.getOption1());
            option2.setText(quizModelClass.getOption2());
            option3.setText(quizModelClass.getOption3());
            option4.setText(quizModelClass.getOption4());
        } else if (i == 2) {
            option1.setText(quizModelClass.getOption2());
            option2.setText(quizModelClass.getOption4());
            option3.setText(quizModelClass.getOption1());
            option4.setText(quizModelClass.getOption3());
        } else if (i == 3) {
            option1.setText(quizModelClass.getOption4());
            option2.setText(quizModelClass.getOption1());
            option3.setText(quizModelClass.getOption2());
            option4.setText(quizModelClass.getOption3());
        } else if (i == 4) {
            option1.setText(quizModelClass.getOption3());
            option2.setText(quizModelClass.getOption2());
            option3.setText(quizModelClass.getOption4());
            option4.setText(quizModelClass.getOption1());
        }

    }

    public void reverseTimer(int Seconds, final TextView tv) {

        new CountDownTimer(Seconds * 1000 + 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText("TIME : " + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Completed");
            }
        }.start();
    }
}