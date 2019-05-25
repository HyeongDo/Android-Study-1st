package com.example.vocaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuizAnimalChoice extends AppCompatActivity {
    ImageView quizMeanBtn, quizPictureBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizanimalchoice);

        quizMeanBtn = (ImageView)findViewById(R.id.quizMeanBtn);
        quizPictureBtn = (ImageView)findViewById(R.id.quizPictureBtn);

        quizMeanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizAnimalMean1.class);
                startActivity(i);
            }
        });

        quizPictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizAnimalPicture1.class);
                startActivity(i);
            }
        });
    }
}
