package com.example.fuelcap;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Bundle;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    ProgressBar splash;
    VideoView video1;


    private static int Splash_Time = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //removes the top bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        //declare progress bar
        splash = findViewById(R.id.splash);
        //declares videoview
        video1 = (VideoView)findViewById(R.id.video1);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.fuelcapvideologo;
        Uri uri = Uri.parse(videopath);
        video1.setVideoURI(uri);
        video1.start();


        //loops the video
        video1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                video1.start();
            }
        });
      progressStart();
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent sIntent = new Intent(SplashActivity.this, MainActivity.class);
              startActivity(sIntent);
              finish();
          }
      },Splash_Time);

    }
        public void progressStart(){
            ObjectAnimator.ofInt(splash, "progress",100)
                    .setDuration(4000)
                    .start();
        }


    }

