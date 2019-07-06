package com.example.myapplication;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   CircleProgressBar circleProgressBar;
   private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleProgressBar.setProgress(70);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<MypageFunding> dataList = new ArrayList<>();

        dataList.add(new MypageFunding("망원동에서","목표금액 : 200,000원","펀딩된 자산 : 10,000원","내가 펀딩한 자산 : 5,000원",
                "투자인원 : 10명", "진행률 : 10%",circleProgressBar));

        adapter = new RecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);



    }
}
