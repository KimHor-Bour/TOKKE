package com.example.kessseller.Java;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kessseller.ButtonSheet.BTSCreatedDescriptionEvent;
import com.example.kessseller.R;

public class CreateEventScreen extends AppCompatActivity {
    ImageView imageView;
    LinearLayout linearLayout;
    Context context;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_item_event);

        imageView = findViewById(R.id.back_arrow_createvent);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        linearLayout = findViewById(R.id.tapDescription);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTSCreatedDescriptionEvent btsCreatedDescription = new BTSCreatedDescriptionEvent(context);
                btsCreatedDescription.show(getSupportFragmentManager(), BTSCreatedDescriptionEvent.class.getSimpleName());
            }
        });

    }
}
