package com.example.productionprojectfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class SignUp extends AppCompatActivity {
    ImageView logoimage;
    TextView title, tagline;
    TextInputLayout firstname, lastname, email, institution, password;
    Button signup, signincall;


    long  id = 0;
    FirebaseDatabase rootNode;
    DatabaseReference refrence, ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.pewter));
        }

        logoimage = findViewById(R.id.logoimagesmall);
        title = findViewById(R.id.welcome);
        tagline = findViewById(R.id.signupforawesome);
        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        institution = findViewById(R.id.instituition);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.btnsignup);
        signincall = findViewById(R.id.btncallsignin);
        signincall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                Pair[] pairs = new Pair[8];
                pairs[0] = new Pair<View,String>(logoimage, "logo_image");
                pairs[1] = new Pair<View,String>(title, "logo_text");
                pairs[2] = new Pair<View,String>(tagline, "tag_line");
                pairs[3] = new Pair<View,String>(email, "email_box");
                pairs[4] = new Pair<View,String>(password, "password_box");
                pairs[5] = new Pair<View,String>(institution, "forget_password_btn");
                pairs[6] = new Pair<View,String>(signincall, "sign_up_btn");
                pairs[7] = new Pair<View,String>(signup, "sign_in_btn");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                refrence = rootNode.getReference("users");
                refrence.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            id = (snapshot.getChildrenCount());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });

                if(!validateFirstName() | !validateLastName() | !validateEmail() | !validateInstitution() | !validatePassword()){
                    return;
                }
                String fnames = firstname.getEditText().getText().toString();
                String lnames = lastname.getEditText().getText().toString();
                String emails = email.getEditText().getText().toString();
                String instituitions = institution.getEditText().getText().toString();
                String passwords = password.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(fnames, lnames, emails, instituitions, passwords);


                refrence.child(String.valueOf(id+1)).setValue(helperClass);
            }
        });
    }

    private boolean validateFirstName(){
        String valfn = firstname.getEditText().getText().toString();

        if(valfn.isEmpty()){
            firstname.setError("Field Should not be empty");
            return false;
        }
        else{
            firstname.setError(null);
            return true;
        }
    }

    private boolean validateLastName(){
        String valln = lastname.getEditText().getText().toString();

        if(valln.isEmpty()){
            lastname.setError("Field Should not be empty");
            return false;
        }
        else{
            lastname.setError(null);
            return true;
        }
    }

    private boolean validateEmail(){
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

    private boolean validateInstitution(){
        String valin = institution.getEditText().getText().toString();

        if(valin.isEmpty()){
            institution.setError("Field Should not be empty");
            return false;
        }
        else{
            institution.setError(null);
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
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
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