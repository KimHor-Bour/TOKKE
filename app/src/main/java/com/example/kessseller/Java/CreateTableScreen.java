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

import com.example.kessseller.R;

public class CreateTableScreen extends AppCompatActivity {
    ImageView imageView;
    Context context;
    private  Activity mActivity;
    LinearLayout mClayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_item_table);

        mActivity = CreateTableScreen.this;
        mClayout = (LinearLayout)findViewById(R.id.layout_create_table);
        mClayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);

            }
        });
        imageView = findViewById(R.id.back_arrow_createtable);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

//   private void closeKeyBoard(){
//        View view = this.getCurrentFocus();
//        if (view != null){
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
//        }
//   }
}
