package com.example.kessseller.XML;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.kessseller.Java.Viewpager;
import com.example.kessseller.R;
import com.google.android.material.tabs.TabLayout;

public class BookingTab extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    Viewpager viewpagerAdapter;
    private Order tab1;
    private Booking tab2;
    private Status tab3;

    LinearLayout filter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_bar,container,false);

        //Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //set the Toolbar tto act as the Action bar for this activity window
        //make sure the toolbar exists in the activity  and is not null
//        setSupportActionBar(toolbar);

        viewPager = view.findViewById(R.id.viewPager);
        viewpagerAdapter = new Viewpager(getFragmentManager());
        tab1= new Order();
        tab2 = new Booking();
        tab3 = new Status();

        viewpagerAdapter.addItem(tab1, "Order");
        viewpagerAdapter.addItem(tab2, "Booking");
        viewpagerAdapter.addItem(tab3, "Status");
        viewPager.setAdapter(viewpagerAdapter);
        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
