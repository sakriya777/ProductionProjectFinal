package com.example.productionprojectfinal.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity {
    ImageView image;
    TextView title, smalltext;
    TextInputLayout email, password;
    Button frgtpasswd, signin, callSignup;
    FirebaseAuth auth;
    String valem, valpw;
    ProgressBar progressBar;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

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
        progressBar = findViewById(R.id.top_progress_bar);
        auth = FirebaseAuth.getInstance();

        if (user != null) {
            Intent intent = new Intent(Login.this, HomeScreen.class);
            startActivity(intent);
        }
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                valem = email.getEditText().getText().toString();
                valpw = password.getEditText().getText().toString();
                if (validateEmail() & validatePassword()) {
                    auth.signInWithEmailAndPassword(valem, valpw)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);

                                        Intent intent = new Intent(Login.this, HomeScreen.class);

                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                }
                progressBar.setVisibility(View.GONE);
            }
        });

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


    private boolean validateEmail() {

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


        if (valpw.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void withoutsignin(View view) {
        Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
        startActivity(intent);
    }
}