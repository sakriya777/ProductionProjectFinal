package com.example.productionprojectfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;

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
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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
                pairs[0] = new Pair<View,String>(image, "logo_image");
                pairs[1] = new Pair<View,String>(title, "logo_text");
                pairs[2] = new Pair<View,String>(smalltext, "tag_line");
                pairs[3] = new Pair<View,String>(email, "email_box");
                pairs[4] = new Pair<View,String>(password, "password_box");
                pairs[5] = new Pair<View,String>(frgtpasswd, "forget_password_btn");
                pairs[6] = new Pair<View,String>(callSignup, "sign_up_btn");
                pairs[7] = new Pair<View,String>(signin, "sign_in_btn");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
    private boolean ValidateEmail(){
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

    private boolean validatePassword(){
        String valpw = password.getEditText().getText().toString();

        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (valpw.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else if (!valpw.matches(passwordVal)) {
            password.setError("Password is too weak");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
}