package com.apifytech.schoolhub;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {



    private DrawerLayout drawerLayout;
    private MaterialToolbar toolbar;
    private FrameLayout fragmentHost;
    private NavigationView navView;
    private BottomNavigationView bottomNavigationView;
    private NavigationHandler navigationHandler;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initializeViews();
        setupToolbar();



        navView.setNavigationItemSelectedListener(item -> {
            String title = item.getTitle().toString(); // Get menu item title
            NavigationHandler navigationHandler = new NavigationHandler(this); // Create an instance of NavigationHandler
            navigationHandler.handleNavigationAction(title); // Handle the selected action
            drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer
            return true;
        });
        setupBottomNavigation();
        updateHeaderData();

    }




    private void initializeViews() {


        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        fragmentHost = findViewById(R.id.fragment_host);
        navView = findViewById(R.id.navView);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Initialize Navigation Handler
        navigationHandler = new NavigationHandler(this);
        navView.setItemIconTintList(null); // Preserve Original Icons



    }

    private void updateHeaderData() {

        View headerView = navView.inflateHeaderView(R.layout.header);
        TextView username = headerView.findViewById(R.id.Username);
        TextView userId = headerView.findViewById(R.id.userId);
        ImageView imageProfile = headerView.findViewById(R.id.imageProfile);



    }

    private void setupToolbar() {
        // Toolbar-এ অ্যাকশন যুক্ত করা
        toolbar.setNavigationOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(navView)) {
                drawerLayout.closeDrawer(navView);
            } else {
                drawerLayout.openDrawer(navView);
            }
        });
    }

    private void setupBottomNavigation() {
        // BottomNavigation-এ ক্লিক ইভেন্ট যুক্ত করা

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getTitle().toString()) {
                    case "QUIZ":
                        // QUIZ Fragment/Activity লোড করুন
                        Toast.makeText(MainActivity.this, "QUIZ", Toast.LENGTH_SHORT).show();
                        return true;

                    case "E-BOOK":
                        // E-BOOK Fragment/Activity লোড করুন
                        Toast.makeText(MainActivity.this, "E-BOOK", Toast.LENGTH_SHORT).show();
                        return true;

                    case "Math Formulas":
                        // Math Formulas Fragment/Activity লোড করুন
                        Toast.makeText(MainActivity.this, "Math Formulas", Toast.LENGTH_SHORT).show();

                        return true;

                    default:
                        return false;
                }
            }
        });


    }






}