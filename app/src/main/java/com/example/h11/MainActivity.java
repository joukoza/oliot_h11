package com.example.h11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    boolean isEditable = true;
    int textSize = 18;
    int textColor;
    int backgroundColor;
    int rows = 1;
    FragmentMain mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

        /* Creating fragments here so that they retain their information.
        * I at some point at least thought that this was necessary. */
        Fragment fragMain = new FragmentMain();
        Fragment fragSet = new FragmentSettings();

        /* Default colors. */
        backgroundColor = getResources().getColor(R.color.white, null);
        textColor = getResources().getColor(R.color.black, null);

        /* Load the main fragment during startup. */
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                fragMain).commit();

        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_main:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                fragMain).commit();
                        break;
                    case R.id.nav_settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                fragSet).commit();
                        break;
                }

                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    public void updateSettings(View v){
        FragmentSettings settingsFragment = (FragmentSettings) getSupportFragmentManager().
                findFragmentById(R.id.fragment_container);
        String text = settingsFragment.getSwitchState();
        if (text.equals("EDITABLE")){
            isEditable = true;
        }
        else {
            isEditable = false;
        }

        textSize = settingsFragment.getTextSize();
        textColor = settingsFragment.getTextColor();
        backgroundColor = settingsFragment.getBackgroundColor();
        rows = settingsFragment.getRows();
    }

    public void getSettings(View v){

        mainFragment = (FragmentMain) getSupportFragmentManager().
                findFragmentById(R.id.fragment_container);

        if (isEditable){
            mainFragment.enableEditText();
        }
        else {
            mainFragment.disableEditText();
            mainFragment.setTextView();
        }

        mainFragment.setTextSize(textSize);
        mainFragment.setTextColor(textColor);
        mainFragment.setBackgroundColor(backgroundColor);
        mainFragment.setRows(rows);
    }

}