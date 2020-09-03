package com.example.kessseller.XML;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.kessseller.R;

public class ScreenKess extends Activity {
    Button btnbooking, btnappointment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_app);

        btnappointment = (Button)findViewById(R.id.screen_appointment);
        btnappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenKess.this, AppointmentScreen.class);
                startActivity(intent);
            }
        });

        btnbooking = (Button) findViewById(R.id.screen_booking);
        btnbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenKess.this, BookingScreen.class);
                startActivity(intent);
            }
        });




    }
}
