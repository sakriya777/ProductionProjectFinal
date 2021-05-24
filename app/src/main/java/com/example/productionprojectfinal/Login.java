package com.example.productionprojectfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Login extends AppCompatActivity {
    ImageView image;
    TextView title, smalltext;
    TextInputLayout email, password;
    Button frgtpasswd, signin, callSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.pewter));
        }
        title = findViewById(R.id.hellothere);
        image = findViewById(R.id.logoimagesmall);
        smalltext = findViewById(R.id.signintoocontinue);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        frgtpasswd = findViewById(R.id.btnforgotpassword);
        callSignup = findViewById(R.id.btncallsignup);
        signin = findViewById(R.id.btnsignin);

        callSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                Pair[] pairs = new Pair[8];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(title, "logo_text");
                pairs[2] = new Pair<View, String>(smalltext, "tag_line");
                pairs[3] = new Pair<View, String>(email, "email_box");
                pairs[4] = new Pair<View, String>(password, "password_box");
                pairs[5] = new Pair<View, String>(frgtpasswd, "forget_password_btn");
                pairs[6] = new Pair<View, String>(callSignup, "sign_up_btn");
                pairs[7] = new Pair<View, String>(signin, "sign_in_btn");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }

    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }

    public static String DecodeString(String string) {
        return string.replace(",", ".");
    }


    private boolean validateEmail() {
        String valem = email.getEditText().getText().toString();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (valem.isEmpty()) {
            email.setError("Field cannot be empty");
            return false;
        } else if (!valem.matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String valpw = password.getEditText().getText().toString();

        if (valpw.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    public void signinprc(View view) {
        if (!validatePassword() | !validateEmail()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        String userEnteredEmail = EncodeString(email.getEditText().getText().toString().trim());
        String userEnteredPassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("emails").equalTo(userEnteredEmail);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    email.setError(null);
                    email.setErrorEnabled(false);

                    String passwordFromDB = snapshot.child(userEnteredEmail).child("passwords").getValue(String.class);

                    if (userEnteredPassword.equals(passwordFromDB)) {


                        password.setError(null);
                        password.setErrorEnabled(false);

                        //String passwordFromDB = snapshot.child(userEnteredEmail).child("password").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), FirstScreen.class);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);

                    } else {
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                } else {
                    email.setError("No Such User Exists");
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    public void withoutsignin(View view) {
        Intent intent = new Intent(getApplicationContext(), FirstScreen.class);
        startActivity(intent);
    }
}