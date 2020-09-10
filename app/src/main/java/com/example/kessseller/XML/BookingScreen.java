package com.example.kessseller.XML;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.kessseller.Java.MyItemDataDoctor;
import com.example.kessseller.Java.MyItemDataEvent;
import com.example.kessseller.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BookingScreen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_bar_user);

        loadFragment(new BookingTab());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


//
//        final Order order = new Order();
//        Booking booking = new Booking();
//        MyItemScreenBooking myItemScreenBooking = new MyItemScreenBooking();
//
//        final Fragment active = order;
//
//
//        final FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.navi_dashboard,order,order.getClass().getName()).hide(order).commit();
//        fm.beginTransaction().add(R.id.navi_myorder,booking,booking.getClass().getName()).hide(order).commit();
//        fm.beginTransaction().add(R.id.navi_myitems,myItemScreenBooking,myItemScreenBooking.getClass().getName()).hide(order).commit();
//        fm.beginTransaction().add(R.id.navi_cupon,order,order.getClass().getName()).hide(order).commit();
//        fm.beginTransaction().add(R.id.navi_account,order,order.getClass().getName()).hide(order).commit();
//
//
//         BottomNavigationView.OnNavigationItemReselectedListener onNavigationItemReselectedListener = new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @SuppressLint("CheckResult")
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case  R.id.navi_dashboard:
//                        fm.beginTransaction().hide(active).show(order).commit();
//                        active = order;
//                        getAppBarLyout(false);
//                        return true;
//                }
//            }
//        };
    }



    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navi_dashboard:
                fragment = new Order();
                break;

            case R.id.navi_myorder:
                fragment = new BookingTab();
                break;

            case R.id.navi_myitems:
                fragment = new MyItemScreenBooking();
                break;

            case R.id.navi_cupon:
                fragment = new MyItemDataDoctor();
                break;
            case R.id.navi_account:
                fragment = new MyItemDataEvent();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
