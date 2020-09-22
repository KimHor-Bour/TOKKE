package com.example.kessseller.Java;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.kessseller.Fragment.AppointmentFragment;
import com.example.kessseller.Fragment.MyItemDataEventFragment;
import com.example.kessseller.Fragment.MyItemDataRoomFragment;
import com.example.kessseller.Fragment.MyItemScreenAppointmentFragment;
import com.example.kessseller.Fragment.OrderFragment;
import com.example.kessseller.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppointmentScreen extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;


    final Fragment appointment = AppointmentFragment.newInstance();
    final Fragment myItemScreenAppointment = MyItemScreenAppointmentFragment.newInstance();
    Fragment active = appointment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_bar_appointment);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.fragment_appointment,myItemScreenAppointment,"myitems").hide(myItemScreenAppointment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_appointment,appointment,"myorders").commit();


        bottomNavigationView = findViewById(R.id.bottom_navigation_app);
        BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navi_dashboard_app:
                      return true;
                    case R.id.navi_myorder_app:
                        fragmentManager.beginTransaction().hide(active).show(appointment).commit();
                        active = appointment;
                        return true;
                    case R.id.navi_myitems_app:
                        fragmentManager.beginTransaction().hide(active).show(myItemScreenAppointment).commit();
                        active = myItemScreenAppointment;
                        return true;
                    case R.id.navi_cupon_app:
                      return true;
                    case R.id.navi_account_app:
                        return true;

                }
                return false;
            }
        };
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Toast.makeText(AppointmentScreen.this,"reselected",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
