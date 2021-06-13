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

import com.example.productionprojectfinal.Fragments.SchoolFragments.LessonFragment;
import com.example.productionprojectfinal.Fragments.SchoolFragments.SingleLessonFragment;
import com.example.productionprojectfinal.Models.LessonModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class LessonAdapter extends FirebaseRecyclerAdapter<LessonModel, LessonAdapter.myViewHolder> {
    public LessonAdapter(FirebaseRecyclerOptions<LessonModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull LessonModel model) {
        String names = model.getName();
        String number = model.getNumber();
        String content = model.getContent();
        String lesson = model.getLesson();



        Log.i("Lesson Adapter", names);

        holder.name.setText(names);

        holder.courselesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new SingleLessonFragment(names, number, content, lesson)).addToBackStack(null).commit();

            }
        });
    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_lesson, parent, false);

        return new LessonAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        CardView courselesson;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.lesson_name);
            courselesson = itemView.findViewById(R.id.lesson_card);
        }
    }
}
