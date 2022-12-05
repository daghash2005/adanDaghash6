package com.example.adandaghash2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class nailGelActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int CAMERA_REQUEST = 0 ; // the code for the request from the camera
    private ImageView imageView;
  private Button takePhoto;
  private Bitmap bitmap; // this var will hold the photo camera


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nail_gel);
        imageView=findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        take photo=findViewById(R.id.takePhotoButton);



    }

    @Override
    @RequiresApi(Api= Build.VERSION_CODES.M)
    public void onClick(View view) {
        if (view == takePhoto) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);

                // camera
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, CAMERA_REQUEST);
            } else if (view == imageView)
            // Gallery

        }
    }// close onclick

    // this meyhod grants the permission according
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // if the camera requested permission
        if (requestCode== CAMERA_REQUEST){
            if (grantResults[0]== PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "No Permission Was Granted", Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && requestCode == RESULT_OK) {
            bitmap=(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);


        }
    }
}


}