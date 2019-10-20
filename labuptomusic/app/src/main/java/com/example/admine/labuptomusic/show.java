package com.example.admine.labuptomusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {

    float s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        TextView tv_star=(TextView)findViewById(R.id.tv_star);
        Intent i =getIntent();
        s=i.getFloatExtra("Stars",0);
        tv_star.setText(" You Rated "+s+" Stars");
    }

}
