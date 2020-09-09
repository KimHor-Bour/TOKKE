package com.example.kessseller.Java;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kessseller.ButtonSheet.BTSCreatedDescriptionEvent;
import com.example.kessseller.R;

public class CreateTableScreen extends AppCompatActivity {
    ImageView imageView;
    Context context;
    private  Activity mActivity;
    LinearLayout mClayout,linearLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_item_table);

        imageView = findViewById(R.id.back_arrow_createtable);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        linearLayout = findViewById(R.id.tabDescription3);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTSCreatedDescriptionEvent btsCreatedDescription = new BTSCreatedDescriptionEvent(context);
                btsCreatedDescription.show(getSupportFragmentManager(), BTSCreatedDescriptionEvent.class.getSimpleName());
            }
        });
    }
}
