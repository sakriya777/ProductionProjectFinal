package com.example.productionprojectfinal.Fragments.Enroll;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.productionprojectfinal.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class EnrollClassEnterCredentials extends Fragment {

    public EnrollClassEnterCredentials() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enroll_class_enter_credentials, container, false);

        TextInputEditText id, password;
        Button enrolltoclass;

        id = view.findViewById(R.id.classenrollid);
        password = view.findViewById(R.id.classenrollpassword);

        enrolltoclass = view.findViewById(R.id.enrollclass);

        enrolltoclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ids = id.getText().toString();
                String passwords = password.getText().toString();

                if (ids.isEmpty() & passwords.isEmpty()){
                    Toast.makeText(getContext(), "Enter ID and Password", Toast.LENGTH_SHORT).show();
                }
                else if (ids.isEmpty()){
                    Toast.makeText(getContext(), "Enter ID", Toast.LENGTH_SHORT).show();
                }
                else if (passwords.isEmpty()){
                    Toast.makeText(getContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("classes").child("details");
                    reference.orderByChild("classid").equalTo(ids).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            for (DataSnapshot datas : snapshot.getChildren()) {
                                String dbid = datas.child("classid").getValue().toString();
                                String dbpassword = datas.child("classpassword").getValue().toString();
                                if (dbid.equals(ids) & dbpassword.equals(passwords)){
                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                    String uid = user.getUid();

                                    HashMap<String, String> enrolldata = new HashMap<>();
                                    enrolldata.put("uid", uid);
                                    enrolldata.put("classid", dbid);

                                    DatabaseReference references = FirebaseDatabase.getInstance().getReference("classes").child("enrollments").child(dbid);
                                    references.push().setValue(enrolldata);

                                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("enrollments").child(uid);
                                    ref.push().setValue(enrolldata);

                                    Toast.makeText(getContext(), "Enrolled into the class", Toast.LENGTH_SHORT).show();
                                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new EnrollFragmentScreen()).addToBackStack(null).commit();

                                }
                                else if (!dbid.equals(ids) | !dbpassword.equals(passwords)){
                                    Toast.makeText(getContext(), "Code/ Password Not Matched", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(getContext(), "Error Occurred", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        return view;
    }
}