package com.example.tunemusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer medidiaplayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medidiaplayer = MediaPlayer.create(getApplicationContext(),
                R.raw.mariamarcal_tempodecantar);


    }

    public void executorSom(View view) {

        if (medidiaplayer != null) {
            medidiaplayer.start();
        }


    }

    public void pausarSom(View view) {

        if (medidiaplayer.isPlaying()) {
            medidiaplayer.pause();
        }
    }

    public void stopSom(View view) {

        if (medidiaplayer.isPlaying()) {
            medidiaplayer.stop();
            medidiaplayer = MediaPlayer.create(getApplicationContext(),
                    R.raw.mariamarcal_tempodecantar);


        }
    }
}



