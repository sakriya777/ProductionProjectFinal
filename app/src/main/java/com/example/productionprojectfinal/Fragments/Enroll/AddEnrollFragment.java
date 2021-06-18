package com.example.productionprojectfinal.Fragments.Enroll;

import android.content.Intent;
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

import com.example.productionprojectfinal.Activities.Login;
import com.example.productionprojectfinal.Activities.SignUp;
import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class AddEnrollFragment extends Fragment {

    DatabaseReference databaseReference;
    FirebaseUser user;
    String key;
    String classid = "";
    public AddEnrollFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_enroll, container, false);

        TextInputEditText classname, classdescription, classpassword;
        TextView classidno;
        Button addclass;

        classname = view.findViewById(R.id.classname);
        classdescription = view.findViewById(R.id.classdescription);
        classpassword = view.findViewById(R.id.classpassword);
        classidno = view.findViewById(R.id.classid);
        addclass = view.findViewById(R.id.addclass);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("classes").child("details");

        key =  databaseReference.push().getKey();

        classid = key.substring(1,8);
        classidno.setText(classid);

        addclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                String classnames = classname.getText().toString();
                String classdescriptions = classdescription.getText().toString();
                String classpasswords = classpassword.getText().toString();

                if (classnames.isEmpty() & classdescriptions.isEmpty() & classpasswords.isEmpty()) {
                    Toast.makeText(getContext(), "Enter all the fields", Toast.LENGTH_SHORT).show();
                } else if (classnames.isEmpty()) {
                    Toast.makeText(getContext(), "Enter class name", Toast.LENGTH_SHORT).show();
                } else if (classdescriptions.isEmpty()) {
                    Toast.makeText(getContext(), "Enter description", Toast.LENGTH_SHORT).show();
                } else if (classpasswords.isEmpty()) {
                    Toast.makeText(getContext(), "Enter password", Toast.LENGTH_SHORT).show();
                } else {

                    HashMap<String, String> classdetails = new HashMap<>();

                    classdetails.put("classid", classid);
                    classdetails.put("classname", classnames);
                    classdetails.put("classdescription", classdescriptions);
                    classdetails.put("classpassword", classpasswords);
                    classdetails.put("classkey", key);
                    classdetails.put("uid", uid);

                    databaseReference.child(classid).setValue(classdetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Class Created Sucessfully", Toast.LENGTH_SHORT).show();
                                TeacherEnrollFragmentScreen teacherEnrollFragmentScreen = new TeacherEnrollFragmentScreen();
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.container, teacherEnrollFragmentScreen);
                                fragmentTransaction.commit();

                            } else {
                                Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });


        return view;
    }
}