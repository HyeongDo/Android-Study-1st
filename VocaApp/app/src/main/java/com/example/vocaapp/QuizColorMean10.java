package com.example.vocaapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class QuizColorMean10 extends AppCompatActivity {

    public static String url = "https://dictionary.cambridge.org/ko/media/%EC%98%81%EC%96%B4/us_pron/y/yel/yello/yellow.mp3";
    MediaPlayer player;

    ImageView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizcolormean10);

        play = (ImageView)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        Button preBtn = (Button)findViewById(R.id.preBtn);
        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizColorMean9.class);
                startActivity(i);
            }
        });

        Button nextBtn = (Button)findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }

    public void onButtonClick(View v){
        Toast.makeText(this,"맞았습니다.",Toast.LENGTH_LONG).show();
    }

    public void onButton2Click(View v){
        Toast.makeText(this,"틀렸습니다.",Toast.LENGTH_LONG).show();
    }

    public void onButton3Click(View v){
        Toast.makeText(this,"틀렸습니다.",Toast.LENGTH_LONG).show();
    }

    public void onButton4Click(View v){
        Toast.makeText(this,"틀렸습니다.",Toast.LENGTH_LONG).show();
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
