package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoHolder;
    private static int splash=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        videoHolder=(VideoView) findViewById(R.id.splashscreen);
        Uri video= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splashscreen);
        videoHolder.setVideoURI(video);
        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isFinishing())
                    return;
                startActivity(new Intent(MainActivity.this,fistpage.class));
                finish();
            }
        });
videoHolder.start();

    }
    public boolean onTouchEvent(MotionEvent event)
    {
        try
        {
            videoHolder.stopPlayback();
        }
        catch (Exception ex)
        {

        }
        jump();
        return true;
    }
    private void jump()
    {
        if(isFinishing())
            return;
        startActivity(new Intent(this,fistpage.class));
        finish();
    }
}
