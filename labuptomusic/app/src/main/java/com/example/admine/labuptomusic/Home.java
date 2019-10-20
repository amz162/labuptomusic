package com.example.admine.labuptomusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button rating;

    private AppCompatTextView tvCameraActivity, tvMediaActivity, tvListActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        find();
        listeners();
    }
    public void find()
    {
        rating=(Button)findViewById(R.id.btn_rating) ;
        tvCameraActivity = findViewById(R.id.tv_home_camera_activity);
        tvListActivity = findViewById(R.id.tv_home_list_activity);
        tvMediaActivity = findViewById(R.id.tv_home_media_activity);
    }
    public void listeners()
    {
        tvCameraActivity.setOnClickListener(this);
        tvListActivity.setOnClickListener(this);
        tvMediaActivity.setOnClickListener(this);
        rating.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_rating:
                intent = new Intent(this, ratingbar.class);
                break;
            case R.id.tv_home_camera_activity:
                intent = new Intent(this, CameraActivity.class);
                break;
            case R.id.tv_home_list_activity:
                intent = new Intent(this, ListActivity.class);
                break;
            case R.id.tv_home_media_activity:
                intent = new Intent(this, MediaActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
