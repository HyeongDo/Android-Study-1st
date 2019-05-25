package com.example.vocaapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StudyFood6 extends AppCompatActivity {

    public static String url = "https://dictionary.cambridge.org/ko/media/%EC%98%81%EC%96%B4/us_pron/d/dum/dumpl/dumpling.mp3";
    MediaPlayer player;

    ImageView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studyfood6);

        play = (ImageView)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        Button nextBtn = (Button)findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyFood7.class);
                startActivity(i);
            }
        });

        Button preBtn = (Button)findViewById(R.id.preBtn);
        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyFood5.class);
                startActivity(i);
            }
        });


    }

    public void playAudio(){
        try{
            closePlayer();

            player = new MediaPlayer();
            player.setDataSource(url);
            player.prepare();
            player.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closePlayer(){
        if(player != null){
            player.release();
            player = null;
        }
    }
}
