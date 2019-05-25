package com.example.vocaapp;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.Object;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView mainStdBtn, mainQuizBtn, imageView;
    TextView textView;
    Random random = new Random();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainStdBtn = (ImageView) findViewById(R.id.mainStdBtn);
        mainQuizBtn = (ImageView) findViewById(R.id.mainQuizBtn);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView);


        mainStdBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), StudyActivity.class);
                startActivity(i);
            }
        });

        mainQuizBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(i);
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        int check = random.nextInt(5);

        if(check == 1){
              imageView.setImageResource(R.drawable.school);
            textView.setText("SCHOOL 학교");
        }else if(check == 2){
              imageView.setImageResource(R.drawable.baby);
            textView.setText("BABY 아기");
        }else if(check == 3){
              imageView.setImageResource(R.drawable.bear);
            textView.setText("BEAR 곰");
        }else if(check == 4){
              imageView.setImageResource(R.drawable.seven);
            textView.setText("SEVEN 일곱,칠");
        }else{
              imageView.setImageResource(R.drawable.bank);
            textView.setText("BANK 은행");
        }

    }

}
