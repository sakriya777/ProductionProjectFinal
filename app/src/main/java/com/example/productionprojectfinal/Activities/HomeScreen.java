package com.example.productionprojectfinal.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.productionprojectfinal.Fragments.Chat.ChatFragmentScreen;
import com.example.productionprojectfinal.Fragments.Discussion.DiscussionFragmentScreen;
import com.example.productionprojectfinal.Fragments.Enroll.EnrollFragmentScreen;
import com.example.productionprojectfinal.Fragments.Enroll.TeacherEnrollFragmentScreen;
import com.example.productionprojectfinal.Fragments.FirstScreen.FirstScreenFragment;
import com.example.productionprojectfinal.Fragments.OutSchool.OutSchoolFragmentScreen;
import com.example.productionprojectfinal.Fragments.Profile.ProfileFragmentScreen;
import com.example.productionprojectfinal.Fragments.Quiz.QuizFragmentScreen;
import com.example.productionprojectfinal.Fragments.SchoolFragments.SchoolFragmentScreen;
import com.example.productionprojectfinal.Fragments.Quiz.TeacherQuizFragmentScreen;
import com.example.productionprojectfinal.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView profile;
    TextView roleText;
    Menu menu;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    MenuItem login, profiles, home, chat, discussion, quiz, enroll, logout, school, outschool;
    String userid;
    String role;

    public void NavigationSetting() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.pewter));
        }
        //Menu Hooks
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar_view);

        //Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        NavigationSetting();
        menu = navigationView.getMenu();
        login = menu.findItem(R.id.login);
        logout = menu.findItem(R.id.logout);
        profiles = menu.findItem(R.id.profile);
        home = menu.findItem(R.id.nav_home);
        chat = menu.findItem(R.id.chat);
        discussion = menu.findItem(R.id.discussion);
        quiz = menu.findItem(R.id.quiz);
        enroll = menu.findItem(R.id.enroll);
        school = menu.findItem(R.id.school_courses);
        outschool = menu.findItem(R.id.outschool_courses);
        profile = findViewById(R.id.profilelogo);
        roleText = findViewById(R.id.roletext);


        ImageView profile = findViewById(R.id.profilelogo);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragmentScreen()).addToBackStack(null).commit();
            }
        });

        if (user != null) {
            profile.setVisibility(View.VISIBLE);
            userid = user.getUid();
            quiz.setVisible(false);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
            reference.orderByChild("UID").equalTo(userid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    for (DataSnapshot datas : snapshot.getChildren()) {
                        role = datas.child("role").getValue().toString();
                        roleText.setText(role);
                        if (role.equals("Freelancer")) {
                            enroll.setVisible(false);
                            quiz.setVisible(false);
                            school.setVisible(false);
                        }
                        if (role.equals("Teacher")){
                            enroll.setTitle("Enroll");
                            quiz.setVisible(false);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });
            login.setVisible(false);


        } else {
            logout.setVisible(false);
        }


        getSupportFragmentManager().beginTransaction().add(R.id.container, new FirstScreenFragment()).commit();
    }

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
            return;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new FirstScreenFragment()).addToBackStack(null).commit();
            drawerLayout.closeDrawers();
        }
        if (item.getItemId() == R.id.discussion) {
            if (user == null) {
                Toast.makeText(this, "Please Login/Register to Continue", Toast.LENGTH_SHORT).show();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new DiscussionFragmentScreen()).addToBackStack(null).commit();
                drawerLayout.closeDrawers();
            }

        }
        if (item.getItemId() == R.id.chat) {
            if (user == null) {
                Toast.makeText(this, "Please Login/Register to Continue", Toast.LENGTH_SHORT).show();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ChatFragmentScreen()).addToBackStack(null).commit();
                drawerLayout.closeDrawers();
            }
        }
        if (item.getItemId() == R.id.school_courses) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new SchoolFragmentScreen()).addToBackStack(null).commit();
            drawerLayout.closeDrawers();
        }
        if (item.getItemId() == R.id.enroll) {
            if (user == null) {
                Toast.makeText(this, "Please Login/Register to Continue", Toast.LENGTH_SHORT).show();
            } else if (role.equals("Teacher")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeacherEnrollFragmentScreen()).addToBackStack(null).commit();
                drawerLayout.closeDrawers();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new EnrollFragmentScreen()).addToBackStack(null).commit();
                drawerLayout.closeDrawers();
            }
        }
        if (item.getItemId() == R.id.outschool_courses) {
            if (user == null) {
                Toast.makeText(this, "Please Login/Register to Continue", Toast.LENGTH_SHORT).show();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new OutSchoolFragmentScreen()).addToBackStack(null).commit();
                drawerLayout.closeDrawers();
            }
        }
        if (item.getItemId() == R.id.quiz) {
            if (user == null) {
                Toast.makeText(this, "Please Login/Register to Continue", Toast.LENGTH_SHORT).show();
            } else if (role.equals("Teacher")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeacherQuizFragmentScreen()).addToBackStack(null).commit();
                drawerLayout.closeDrawers();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new QuizFragmentScreen()).addToBackStack(null).commit();
                drawerLayout.closeDrawers();
            }
        }


        if (item.getItemId() == R.id.login) {
            startActivity(new Intent(this, Login.class));
            finish();
        }
        if (item.getItemId() == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, Login.class));
            finish();
        }
        if (item.getItemId() == R.id.profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragmentScreen()).addToBackStack(null).commit();
            drawerLayout.closeDrawers();
        }
        return true;
    }
}