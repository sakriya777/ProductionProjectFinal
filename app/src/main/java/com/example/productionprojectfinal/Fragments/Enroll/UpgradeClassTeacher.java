package com.example.productionprojectfinal.Fragments.Enroll;

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

import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class UpgradeClassTeacher extends Fragment {
    String classid;
    String oldclassid, oldclassdescription, oldclasskey, oldclassname, oldclasspassword, uid;
    String newclassid, classdescription, classkey, classname, classpassword;

    public UpgradeClassTeacher() {
    }

    public UpgradeClassTeacher(String classid) {
        this.classid = classid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upgrade_class_teacher, container, false);


        TextView upclassid;
        TextInputEditText upclassname, upclassdescription, upclasspassword;
        Button upclass;


        upclassid = view.findViewById(R.id.upgradeclassid);
        upclassname = view.findViewById(R.id.upgradeclassname);
        upclassdescription = view.findViewById(R.id.upgradeclassdescription);
        upclasspassword = view.findViewById(R.id.upgradeclasspassword);
        upclass = view.findViewById(R.id.upgradeclass);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("classes").child("details");
        reference.orderByChild("classid").equalTo(classid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    oldclassdescription = datas.child("classdescription").getValue().toString();
                    oldclassid = datas.child("classid").getValue().toString();
                    oldclasskey = datas.child("classkey").getValue().toString();
                    oldclassname = datas.child("classname").getValue().toString();
                    oldclasspassword = datas.child("classpassword").getValue().toString();
                    uid = datas.child("uid").getValue().toString();

                    classkey = reference.push().getKey();

                    newclassid = classkey.substring(1, 8);

                    upclassid.setText(newclassid);

                    upclassname.setText(oldclassname);
                    upclassdescription.setText(oldclassdescription);
                    upclasspassword.setText(oldclasspassword);

                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        upclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String classnames = upclassname.getText().toString();
                String classdescriptions = upclassdescription.getText().toString();
                String classpasswords = upclasspassword.getText().toString();

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

                    classdetails.put("classid", newclassid);
                    classdetails.put("classname", classnames);
                    classdetails.put("classdescription", classdescriptions);
                    classdetails.put("classpassword", classpasswords);
                    classdetails.put("classkey", classkey);
                    classdetails.put("uid", uid);

                    reference.child(newclassid).setValue(classdetails);

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                    databaseReference.child("classes").child("enrollments").child(classid).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                HashMap<String, String> prevstud = new HashMap<>();

                                String studentuid = dataSnapshot.child("uid").getValue().toString();

                                prevstud.put("classid", newclassid);
                                prevstud.put("uid", studentuid);

                                Toast.makeText(getContext(), "Uploading student data", Toast.LENGTH_SHORT).show();
                                databaseReference.child("classes").child("enrollments").child(newclassid).push().setValue(prevstud);

                                databaseReference.child("enrollments").child(studentuid).push().setValue(prevstud);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });


                    TeacherEnrollFragmentScreen teacherEnrollFragmentScreen = new TeacherEnrollFragmentScreen();
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, teacherEnrollFragmentScreen);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}