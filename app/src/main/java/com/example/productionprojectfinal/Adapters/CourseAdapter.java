package com.example.productionprojectfinal.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Fragments.Chat.SingleChatFragment;
import com.example.productionprojectfinal.Fragments.SchoolFragments.LessonFragment;
import com.example.productionprojectfinal.Models.CourseModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

public class CourseAdapter extends FirebaseRecyclerAdapter<CourseModel, CourseAdapter.myViewHolder> {

    String grade, subject;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public CourseAdapter(@NonNull @NotNull FirebaseRecyclerOptions<CourseModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull CourseModel model) {
        String names = model.getName();
        String number = model.getNumber();
        String chap = model.getChap();
        String grades = grade;
        String subjects = subject;
        holder.name.setText(names);

        holder.courselesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new LessonFragment(names, number, chap, grades, subjects)).addToBackStack(null).commit();
            }
        });
    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_chapter_lesson, parent, false);

        return new CourseAdapter.myViewHolder(view);
    }



    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView courselesson;
        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.chapter_name);
            courselesson = itemView.findViewById(R.id.chapter_lesson);
        }
    }
}
