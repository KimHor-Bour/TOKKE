package com.example.kessseller.Java;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kessseller.R;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AlertDialogRadio extends AppCompatActivity {

    LinearLayout linearLayout;
    AlertDialog alertDialog;
    CharSequence[] values = {"All","Booking Request","Booking List","Completed","Cancelled","Booking History",};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_myorder);

        linearLayout = (LinearLayout)findViewById(R.id.filterbtn);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithRadioButtonGroup();
            }
        });

    }
    public void CreateAlertDialogWithRadioButtonGroup(){
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogRadio.this,R.style.MaterialThemeDialog);
        builder.setTitle("Selected Filter");
        builder.setCancelable(true);
        builder.setMessage("my Message");
        builder.setSingleChoiceItems(values,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                CharSequence selectedItem = Arrays.asList(values).get(i);

                Toast.makeText(AlertDialogRadio.this,values[i],Toast.LENGTH_LONG).show();

//                switch (i){
//                    case 0:
//                        Toast.makeText(AlertDialogRadio.this, values[0], Toast.LENGTH_LONG).show();
//                        break;
//                    case 1:
//                        Toast.makeText(AlertDialogRadio.this, values[1], Toast.LENGTH_LONG).show();
//                        break;
//                        case 2:
//                        Toast.makeText(AlertDialogRadio.this, values[2], Toast.LENGTH_LONG).show();
//                        break;
//                        case 3:
//                        Toast.makeText(AlertDialogRadio.this, values[3], Toast.LENGTH_LONG).show();
//                        break;
//                        case 4:
//                        Toast.makeText(AlertDialogRadio.this, values[4], Toast.LENGTH_LONG).show();
//                        break;
//                        case 5:
//                        Toast.makeText(AlertDialogRadio.this, values[5], Toast.LENGTH_LONG).show();
//                        break;
//                }
            }

        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }





}
