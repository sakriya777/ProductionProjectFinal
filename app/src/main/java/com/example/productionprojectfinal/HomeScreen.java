package com.example.productionprojectfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseAuth auth;

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

        getSupportFragmentManager().beginTransaction().add(R.id.container, new FirstScreenFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new FirstScreenFragment()).commit();
            drawerLayout.closeDrawers();
        }
        if (item.getItemId() == R.id.discussion) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new DiscussionFragmentScreen()).commit();
            drawerLayout.closeDrawers();
        }
        if (item.getItemId() == R.id.chat) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ChatFragmentScreen()).commit();
            drawerLayout.closeDrawers();
        }
        if (item.getItemId() == R.id.school_courses) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new SchoolFragmentScreen()).commit();
            drawerLayout.closeDrawers();
        }
        if (item.getItemId() == R.id.outschool_courses) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new OutSchoolFragmentScreen()).commit();
            drawerLayout.closeDrawers();
        }

        if (item.getItemId() == R.id.login) {
            startActivity(new Intent(this, Login.class));
            finish();
        }
        if (item.getItemId() == R.id.logout) {
            auth.signOut();
            startActivity(new Intent(this, Login.class));
            finish();
        }
        if (item.getItemId() == R.id.profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragmentScreen()).commit();
            drawerLayout.closeDrawers();
        }
        return true;
    }
}