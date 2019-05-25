package com.example.vocaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuizActivity extends AppCompatActivity {
    ImageView quizFoodBtn, quizFamilyBtn, quizSchoolBtn, quizAnimalBtn, quizPlaceBtn,
    quizNumberBtn, quizHobbyBtn, quizColorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quizFoodBtn = (ImageView)findViewById(R.id.quizFoodBtn);
        quizFamilyBtn = (ImageView)findViewById(R.id.quizFamilyBtn);
        quizSchoolBtn = (ImageView)findViewById(R.id.quizSchoolBtn);
        quizAnimalBtn = (ImageView)findViewById(R.id.quizAnimalBtn);
        quizPlaceBtn = (ImageView)findViewById(R.id.quizPlaceBtn);
        quizNumberBtn = (ImageView)findViewById(R.id.quizNumberBtn);
        quizHobbyBtn = (ImageView)findViewById(R.id.quizHobbyBtn);
        quizColorBtn = (ImageView)findViewById(R.id.quizColorBtn);

        quizFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizFoodChoice.class);
                startActivity(i);
            }
        });

        quizFamilyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizFamilyChoice.class);
                startActivity(i);
            }
        });

        quizSchoolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizSchoolChoice.class);
                startActivity(i);
            }
        });

        quizAnimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizAnimalChoice.class);
                startActivity(i);
            }
        });

        quizPlaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizPlaceChoice.class);
                startActivity(i);
            }
        });

        quizNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizNumberChoice.class);
                startActivity(i);
            }
        });

        quizHobbyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizHobbyChoice.class);
                startActivity(i);
            }
        });

        quizColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuizColorChoice.class);
                startActivity(i);
            }
        });

    }
}
