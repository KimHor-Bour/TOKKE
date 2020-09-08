package com.example.kessseller.XML;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.kessseller.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppointmentScreen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_bar_appointment);
        //loading the default fragment
        loadFragment(new Appointment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navi_dashboard:
                break;

            case R.id.navi_myorder:
                fragment = new Appointment();
                break;

            case R.id.navi_myitems:
                fragment = new MyItemScreenAppointment();
                break;

            case R.id.navi_cupon:
                break;
            case R.id.navi_account:
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_appointment, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
