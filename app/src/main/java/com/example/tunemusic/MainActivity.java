package com.example.tunemusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer  medidiaplayer;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarSeekBar();

        medidiaplayer = MediaPlayer.create(getApplicationContext(),
                R.raw.mariamarcal_tempodecantar);

    }
    private void inicializarSeekBar(){

        SeekBar seekVolume = findViewById(R.id.seekVolume);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekVolume.setMax(volumeMaximo);
        seekVolume.setProgress( volumeAtual );

        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                audioManager.setStreamVolume( AudioManager.STREAM_MUSIC, i, 0);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



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

    @Override
    protected void onStop() {
        super.onStop();
        if ( medidiaplayer.isPlaying()){
             medidiaplayer.pause();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (medidiaplayer != null && medidiaplayer.isPlaying()){
            medidiaplayer.stop();
            medidiaplayer.release();
            medidiaplayer = null;
        }
    }
}



