package com.example.admine.labuptomusic;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivCapturedImg;
    Button btnOpenCamera;
    private static final int CAMERA_PIC_REQUEST=1;
    public static final int REQUEST_CODE_SOME_FEATURES=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        findviews();
        listeners();
    }
    public void findviews()
    {
        ivCapturedImg=findViewById(R.id.iv_camera_captured_image);
        btnOpenCamera=findViewById(R.id.btn_camera_open_camera);
    }
    public void listeners()
    {
        btnOpenCamera.setOnClickListener(this);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean hasPermission()
    {
        int hasCameraPermission=checkSelfPermission(Manifest.permission.CAMERA);
        int hasStoragePermission=checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        return (hasCameraPermission== PackageManager.PERMISSION_GRANTED && hasStoragePermission==PackageManager.PERMISSION_GRANTED);
    }
    public void openCamera()
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_PIC_REQUEST);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkPermission()
    {
        int hasCameraPermission=checkSelfPermission(Manifest.permission.CAMERA);
        int hasStoragePermission=checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        List<String> permission= new ArrayList<>();
        if(hasCameraPermission!=PackageManager.PERMISSION_GRANTED)
        {permission.add(Manifest.permission.CAMERA);}
        if (hasStoragePermission!=PackageManager.PERMISSION_GRANTED)
        {permission.add(Manifest.permission.READ_EXTERNAL_STORAGE);}
        if (!permission.isEmpty())
        {requestPermissions(permission.toArray(new String[permission.size()]),REQUEST_CODE_SOME_FEATURES);}

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_PIC_REQUEST)
        {
            if(resultCode==RESULT_OK)
            {
                if(data!=null)
                {
                    Bundle extras=data.getExtras();
                    Bitmap bitmapimg=(Bitmap) extras.get("data");
                    ivCapturedImg.setImageBitmap(bitmapimg);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_camera_open_camera:
                if(hasPermission())
                {
                    openCamera();
                }
                else
                    checkPermission();
                break;
        }
    }
}
