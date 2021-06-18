package com.example.productionprojectfinal.Adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Fragments.Enroll.EnrollClassEnterCredentials;
import com.example.productionprojectfinal.Fragments.Enroll.EnrollFragmentScreen;
import com.example.productionprojectfinal.Fragments.Quiz.QuizFragmentScreen;
import com.example.productionprojectfinal.Models.EnrollStudentsModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class StudentViewEnrollAdapter extends FirebaseRecyclerAdapter<EnrollStudentsModel, StudentViewEnrollAdapter.myViewHolder> {

    public StudentViewEnrollAdapter(@NonNull @NotNull FirebaseRecyclerOptions<EnrollStudentsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull EnrollStudentsModel model) {

        String classid = model.getClassid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("classes").child("details");
        reference.orderByChild("classid").equalTo(classid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    String classname = datas.child("classname").getValue().toString();
                    String classid = datas.child("classid").getValue().toString();
                    String classdescription = datas.child("classdescription").getValue().toString();

                    holder.cardtitle.setText(classname);
                    holder.cardid.setText("Class id" + classid);
                    holder.cardpassword.setText(classdescription + "\nClick to start Quiz");

                    holder.classcard.setOnClickListener(new View.OnClickListener() {
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
                                        }})
                                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(activity, "Nayy", Toast.LENGTH_SHORT).show();
                                        }
                                    }).show();
                        }
                    });
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
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_single, parent, false);

        return new StudentViewEnrollAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView cardtitle, cardid, cardpassword;

        CardView classcard;
        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            cardtitle = itemView.findViewById(R.id.cardtitle);
            cardid = itemView.findViewById(R.id.cardclassid);
            cardpassword = itemView.findViewById(R.id.cardclasspassword);

            classcard = itemView.findViewById(R.id.classcardone);
        }
    }

}
