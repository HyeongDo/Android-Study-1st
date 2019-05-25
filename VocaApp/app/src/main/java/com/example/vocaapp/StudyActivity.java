package com.example.vocaapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StudyActivity extends AppCompatActivity {
    ImageView stdFoodBtn, stdFamilyBtn, stdSchoolBtn,
            stdAnimalBtn, stdPlaceBtn, stdNumberBtn,
            stdHobbyBtn, stdColorBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        stdFoodBtn = (ImageView)findViewById(R.id.stdFoodBtn);
        stdFamilyBtn = (ImageView)findViewById(R.id.stdFamilyBtn);
        stdSchoolBtn = (ImageView)findViewById(R.id.stdSchoolBtn);
        stdAnimalBtn = (ImageView)findViewById(R.id.stdAnimalBtn);
        stdNumberBtn = (ImageView)findViewById(R.id.stdNumberBtn);
        stdPlaceBtn = (ImageView)findViewById(R.id.stdPlaceBtn);
        stdHobbyBtn = (ImageView)findViewById(R.id.stdHobbyBtn);
        stdColorBtn = (ImageView)findViewById(R.id.stdColorBtn);

        stdFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyFood1.class);
                startActivity(i);
            }
        });

        stdFamilyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyFamily1.class);
                startActivity(i);
            }
        });

        stdSchoolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudySchool1.class);
                startActivity(i);
            }
        });

        stdAnimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyAnimal1.class);
                startActivity(i);
            }
        });

        stdNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyNumber1.class);
                startActivity(i);
            }
        });

        stdPlaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyPlace1.class);
                startActivity(i);
            }
        });

        stdColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyColor1.class);
                startActivity(i);
            }
        });

        stdHobbyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudyHobby1.class);
                startActivity(i);
            }
        });
    }
}
