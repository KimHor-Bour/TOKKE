package com.example.kessseller.Java;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.kessseller.Fragment.BookingFragment;
import com.example.kessseller.Fragment.BookingTabFragment;
import com.example.kessseller.Fragment.MyItemDataTableFragment;
import com.example.kessseller.Fragment.MyItemScreenBookingFragment;
import com.example.kessseller.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BookingScreen extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;

    final Fragment bookingTab = BookingTabFragment.newInstance();
    final Fragment myItemScreenBooking = MyItemScreenBookingFragment.newInstance();
     Fragment active = bookingTab;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_bar_user);

        fragmentManager = getSupportFragmentManager();

       fragmentManager.beginTransaction().add(R.id.fragment_container_user, bookingTab, "myitems").hide(bookingTab).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container_user, myItemScreenBooking, "myorders").hide(myItemScreenBooking).commit();


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navi_dashboard:
                      return true;
                    case R.id.navi_myorder:
                        fragmentManager.beginTransaction().hide(active).show(bookingTab).commit();
                        active = bookingTab;
                        return true;
                    case R.id.navi_myitems:
                        fragmentManager.beginTransaction().hide(active).show(myItemScreenBooking).commit();
                        active = myItemScreenBooking;
                        return true;
                    case R.id.navi_cupon:
                      return true;
                    case R.id.navi_account:
                        return true;

                }
                return false;
            }
        };

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

                bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Toast.makeText(BookingScreen.this, "reselected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
