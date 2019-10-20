package com.example.admine.labuptomusic;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.net.Uri;
import android.widget.Toast;
import com.example.admine.labuptomusic.R;

import java.io.IOException;

public class AudioPlayerHelper {
    private MediaPlayer mMediaPlayer;
    int length=0;
    public void stop() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }


    public void pause(){
        if(mMediaPlayer!=null)
        {
            mMediaPlayer.pause();
            length=mMediaPlayer.getCurrentPosition();
        }
    }

    public void resume(){
        if(mMediaPlayer!=null)
        {
            mMediaPlayer.seekTo(length);
            mMediaPlayer.start();
        }
    }

    public void play(final Context context,  Uri uri) {
        mMediaPlayer = MediaPlayer.create(context, uri);
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            stop();
            Toast.makeText(context,
                    context.getResources().getString(R.string.msg_audio_completed),
                    Toast.LENGTH_LONG).show();
        }
        });
        mMediaPlayer.start(); }
}
