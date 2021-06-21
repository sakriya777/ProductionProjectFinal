package com.example.productionprojectfinal.Adapters;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Models.QuizModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import java.util.Random;

import static java.security.AccessController.getContext;

public class QuizAdapter extends FirebaseRecyclerAdapter<QuizModel, QuizAdapter.myViewHolder> {

    String role;
    int answer;
    AppCompatActivity activity;
    public QuizAdapter(@NonNull @NotNull FirebaseRecyclerOptions<QuizModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull QuizModel model) {
        holder.question.setText(model.getQuestion());

        Random r = new Random();
        int i = r.nextInt(4 - 1) + 1;

        if (i == 1) {
            holder.option1.setText(model.getOption1());
            holder.option2.setText(model.getOption2());
            holder.option3.setText(model.getOption3());
            holder.option4.setText(model.getOption4());
        } else if (i == 2) {
            holder.option1.setText(model.getOption2());
            holder.option2.setText(model.getOption4());
            holder.option3.setText(model.getOption1());
            holder.option4.setText(model.getOption3());
        } else if (i == 3) {
            holder.option1.setText(model.getOption4());
            holder.option2.setText(model.getOption1());
            holder.option3.setText(model.getOption2());
            holder.option4.setText(model.getOption3());
        } else if (i == 4) {
            holder.option1.setText(model.getOption3());
            holder.option2.setText(model.getOption2());
            holder.option3.setText(model.getOption4());
            holder.option4.setText(model.getOption1());
        }


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    role = datas.child("role").getValue().toString();
                    if (role.equals("Teacher")) {
                        holder.option1.setEnabled(false);
                        holder.option2.setEnabled(false);
                        holder.option3.setEnabled(false);
                        holder.option4.setEnabled(false);
                        holder.option1.setTextColor(Color.GREEN);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    @NonNull
    @NotNull
    @Override
    public QuizModel getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlequestion, parent, false);

        return new QuizAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        RadioGroup options;
        Button completequiz;
        RadioButton option1, option2, option3, option4;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            activity = (AppCompatActivity) itemView.getContext();
            question = itemView.findViewById(R.id.singlequestion);

            options = itemView.findViewById(R.id.options);
            option1 = itemView.findViewById(R.id.singleoption1);
            option2 = itemView.findViewById(R.id.singleoption2);
            option3 = itemView.findViewById(R.id.singleoption3);
            option4 = itemView.findViewById(R.id.singleoption4);

            completequiz = itemView.findViewById(R.id.completequiz);
        }
    }
}