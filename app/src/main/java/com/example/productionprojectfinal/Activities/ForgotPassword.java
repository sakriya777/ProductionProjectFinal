package com.example.productionprojectfinal.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Button send = findViewById(R.id.sendresetbtn);
        TextInputLayout email = findViewById(R.id.email);
        FirebaseAuth auth = FirebaseAuth.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emails = email.getEditText().getText().toString();
                if (emails.isEmpty()){
                    Toast.makeText(ForgotPassword.this, "Enter a email First", Toast.LENGTH_SHORT).show();
                }
                else{
                    auth.sendPasswordResetEmail(emails)
                            .addOnCompleteListener(new OnCompleteListener() {
                                @Override
                                public void onComplete(@NonNull Task task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(ForgotPassword.this, "Check email to reset your password!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(ForgotPassword.this, Login.class));

                                    } else {
                                        Toast.makeText(ForgotPassword.this, "Fail to send reset password email!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}