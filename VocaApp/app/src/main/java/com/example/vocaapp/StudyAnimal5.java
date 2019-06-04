package com.example.vocaapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StudyAnimal5 extends AppCompatActivity {

    public static String url = "https://dictionary.cambridge.org/ko/media/%EC%98%81%EC%96%B4/us_pron/b/bar/bare_/bare.mp3";
    MediaPlayer player;

    ImageView play;

    TextView korName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studyanimal5);

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
                Intent i = new Intent(getApplicationContext(),StudyAnimal6.class);
                startActivity(i);
            }
        });

        Button preBtn = (Button)findViewById(R.id.preBtn);
        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyAnimal4.class);
                startActivity(i);
            }
        });

        korName = (TextView)findViewById(R.id.korName);
        korName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setKorName();
            }
        });



    }

    public void setKorName(){
        korName = (TextView)findViewById(R.id.korName);
        korName.setText("곰");
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
