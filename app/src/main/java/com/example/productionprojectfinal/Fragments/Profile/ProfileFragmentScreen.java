package com.example.productionprojectfinal.Fragments.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.productionprojectfinal.Fragments.Enroll.EnrollClassEnterCredentials;
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

public class ProfileFragmentScreen extends Fragment {
    String oldroles, oldfnames, oldlnames, oldinstituitions, oldemails, key, olduid;
    public ProfileFragmentScreen() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_fragment_screen, container, false);

        TextInputEditText fname, lname, email, role, instituition;
        Button submiteditbtn;

        submiteditbtn = view.findViewById(R.id.submitedit);

        fname = view.findViewById(R.id.fnameedit);
        lname = view.findViewById(R.id.lnameedit);
        email = view.findViewById(R.id.emailedit);
        role = view.findViewById(R.id.roleedit);
        instituition = view.findViewById(R.id.instituitionedit);

        email.setEnabled(false);
        role.setEnabled(false);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cannot change the Email", Toast.LENGTH_SHORT).show();
            }
        });
        role.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cannot change the Role", Toast.LENGTH_SHORT).show();
            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    oldroles = datas.child("role").getValue().toString();
                    oldfnames = datas.child("fname").getValue().toString();
                    oldlnames = datas.child("lname").getValue().toString();
                    oldinstituitions = datas.child("instituion").getValue().toString();
                    oldemails = datas.child("email").getValue().toString();
                    olduid = datas.child("UID").getValue().toString();
                    key = datas.getKey();

                    fname.setText(oldfnames);
                    lname.setText(oldlnames);
                    role.setText(oldroles);
                    instituition.setText(oldinstituitions);
                    email.setText(oldemails);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        submiteditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newfnames = fname.getText().toString();
                String newlnames = lname.getText().toString();
                String newinstituitions = instituition.getText().toString();

                if (!newfnames.equals(oldfnames) | !newlnames.equals(oldlnames) |!newinstituitions.equals(oldinstituitions)){
                    HashMap<String, String> editdata = new HashMap<>();
                    editdata.put("key", key);
                    editdata.put("lname", newlnames);
                    editdata.put("fname", newfnames);
                    editdata.put("email", oldemails);
                    editdata.put("role", oldroles);
                    editdata.put("UID", olduid);
                    editdata.put("instituion", newinstituitions);


                    reference.child(key).setValue(editdata);

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragmentScreen()).commit();
                }
            }
        });

        return view;
    }
}