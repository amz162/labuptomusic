package com.example.admine.labuptomusic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class ratingbar extends AppCompatActivity implements View.OnClickListener {

    RatingBar rate ;
    EditText msg;
    Button btn_rate,sends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);
        btn_rate=(Button)findViewById(R.id.btn_rate);
        rate =(RatingBar)findViewById(R.id.rb_star);
        msg =(EditText)findViewById(R.id.mesag);
        sends=(Button)findViewById(R.id.send);
        sends.setOnClickListener(this);
    }


    public void Rating(View view){

        float rating= rate.getRating();

        Intent gotosecond=new Intent(this,show.class);
        gotosecond.putExtra("Stars",rating);
        startActivity(gotosecond);
    }

    @Override
    public void onClick(View v) {
        String message = msg.getText().toString();
        Uri Dest= Uri.parse("smsto:03495324668");
        Intent intent =new Intent(Intent.ACTION_SENDTO,Dest);
        intent.putExtra("sms_body",message);
        startActivity(intent);
    }
}
