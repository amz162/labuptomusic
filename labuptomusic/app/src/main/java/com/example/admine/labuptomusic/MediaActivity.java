package com.example.admine.labuptomusic;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.admine.labuptomusic.R;
import com.example.admine.labuptomusic.AudioPlayerHelper;

import java.io.IOException;


public class MediaActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton btnPlay, btnStop, btnPauseResume;
    private AudioPlayerHelper audioPlayerHelperInstance = null;
    Uri uriSound;
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        btnPlay = findViewById(R.id.btn_media_play);
        btnStop = findViewById(R.id.btn_media_stop);
        btnPauseResume = findViewById(R.id.btn_media_pause_resume);
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPauseResume.setOnClickListener(this);
        Button openFile = (Button) this.findViewById(R.id.btn_choose_media);
        openFile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 10);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK && requestCode == 10){
            uriSound=data.getData();

        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_media_play:
                getAudioPlayerInstance().play(this,  uriSound);
                btnPauseResume.setText(getString(R.string.action_pause));
                break;
            case R.id.btn_media_stop:
                getAudioPlayerInstance().stop();
                break;
            case R.id.btn_media_pause_resume:
                if(btnPauseResume.getText().toString().equalsIgnoreCase(getString(R.string.action_resume))) {

                    btnPauseResume.setText(getString(R.string.action_pause));
                    getAudioPlayerInstance().resume();
                }
                else {

                    btnPauseResume.setText(getString(R.string.action_resume));
                    getAudioPlayerInstance().pause();
                }
                break;
        }
    }

    private AudioPlayerHelper getAudioPlayerInstance() {
        if (audioPlayerHelperInstance == null) {
            audioPlayerHelperInstance = new AudioPlayerHelper();
        }
        return audioPlayerHelperInstance;
    }
}