package com.example.audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //코끼리
    //public static String url = "https://dictionary.cambridge.org/ko/media/%EC%98%81%EC%96%B4/us_pron/e/eus/eus75/eus75655.mp3";
    //놀이동산
    public static String url = "https://dictionary.cambridge.org/ko/media/%EC%98%81%EC%96%B4/us_pron/h/ham/hambu/hamburger.mp3";


    MediaPlayer player;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palyAudio();

            }
        });

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseAudio();
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resumeAudio();
            }
        });
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
            }
        });

    }

    public void pauseAudio(){
        if(player!=null){
            position = player.getCurrentPosition();
            player.pause();

            Toast.makeText(this,"일시정지됨",Toast.LENGTH_LONG);

        }
    }

    public void resumeAudio(){
        if(player!=null && !player.isPlaying()){
            player.seekTo(position);
            player.start();
            Toast.makeText(this,"재시작됨",Toast.LENGTH_LONG);
        }
    }

    public void stopAudio(){
        if(player != null && player.isPlaying()){
            player.stop();
            Toast.makeText(this,"중지됨",Toast.LENGTH_LONG);
        }
    }

    public void palyAudio(){
        try {
            closePlayer();

            player = new MediaPlayer();
            player.setDataSource(url);
            player.prepare();
            player.start();

            Toast.makeText(this,"재생시작됨",Toast.LENGTH_LONG);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void closePlayer(){
      if(player!=null){
          player.release();
          player=null;
      }
    }

}
