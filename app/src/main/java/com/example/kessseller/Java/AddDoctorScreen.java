package com.example.kessseller.Java;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kessseller.ButtonSheet.BTSCreatedDescriptionEvent;
import com.example.kessseller.R;

public class AddDoctorScreen extends AppCompatActivity {
    ImageView imageView;
    LinearLayout linearLayout;
    Context context;
    private static int IMAGE_PICKER_CODE = 1;
//    private static int PERMISSION_CODE = 1001;

    LinearLayout loadImage;
    ImageView imageViewLoad;

    Intent intent;
    String ImageDecode;
    String[] FILE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_item_doctor);


        imageView = findViewById(R.id.back_arrow_createdoctor);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        linearLayout = findViewById(R.id.tabDescription1);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTSCreatedDescriptionEvent btsCreatedDescription = new BTSCreatedDescriptionEvent(context);
                btsCreatedDescription.show(getSupportFragmentManager(), BTSCreatedDescriptionEvent.class.getSimpleName());
            }
        });
        imageViewLoad = findViewById(R.id.imgSelect);
        loadImage=findViewById(R.id.img_click_doctor);
        loadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, IMAGE_PICKER_CODE);

            }
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
//                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
//                        requestPermissions(permissions,PERMISSION_CODE);
//
//                    }else {
//                        picImageFromGallery();
//                    }
//                }else {
//                    picImageFromGallery();
//                }





        });

    }
//    private void picImageFromGallery() {
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        startActivityForResult(intent,IMAGE_PICKER_CODE);
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//      switch (requestCode){
//          case PERMISSION_CODE:
//              {
//              if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                  picImageFromGallery();
//              }else {
//                  Toast.makeText(this,"Permission denied...!",Toast.LENGTH_SHORT).show();
//              }
//          }
//      }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == IMAGE_PICKER_CODE) {
//            imageViewLoad.setImageURI(data.getData());
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == IMAGE_PICKER_CODE && resultCode == RESULT_OK
                    && null != data) {

                Uri URI = data.getData();
                String[] FILE = { MediaStore.Images.Media.DATA };


                Cursor cursor = getContentResolver().query(URI,
                        FILE, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(FILE[0]);
                 ImageDecode= cursor.getString(columnIndex);
                cursor.close();

                imageViewLoad.setImageBitmap(BitmapFactory
                        .decodeFile(ImageDecode));

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
                    .show();
        }

    }
}
