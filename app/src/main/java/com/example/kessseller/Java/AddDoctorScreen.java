package com.example.kessseller.Java;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.kessseller.ButtonSheet.BTSCreatedDescriptionEvent;
import com.example.kessseller.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AddDoctorScreen extends AppCompatActivity {
    ImageView imageView;
    LinearLayout linearLayout;
    Context context;
    private static final int PICK_FROM_GALLERY = 1;
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
                try {
                    if (ActivityCompat.checkSelfPermission(AddDoctorScreen.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(AddDoctorScreen.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PICK_FROM_GALLERY);
                    } else {
                        sellectedImage();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void sellectedImage() {
        final CharSequence[] opt = {"Take Photo", "Choose from Gallery"};
        final AlertDialog.Builder alert = new AlertDialog.Builder(AddDoctorScreen.this);
        alert.setTitle("ADD IMAGE");
        alert.setItems(opt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opt[i].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                } else if (opt[i].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
            }
        });
        alert.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if (requestCode == 1){
//                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                imageViewLoad.setImageBitmap(bitmap);

                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()){
                    if (temp.getName().equals("temp.jpg")){
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOpt = new BitmapFactory.Options();
                    bitmap= BitmapFactory.decodeFile(f.getAbsolutePath(),bitmapOpt);
                    imageViewLoad.setImageBitmap(bitmap);
                    String path = android.os.Environment.getExternalStorageDirectory()+File.separator+
                            "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outputStream = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis())+".jpg");
                    try {
                        outputStream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85,outputStream);
                        outputStream.flush();
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if(requestCode == 2){
                Uri selecteImg = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selecteImg,filePath,null,null,null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePath[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("Path of Image",picturePath+"");
                imageViewLoad.setImageBitmap(thumbnail);
            }
        }
    }
}
