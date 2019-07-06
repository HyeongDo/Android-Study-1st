package com.example.mycr2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Adapter.ClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<CardItem> dataList = new ArrayList<>();

        dataList.add(new CardItem("안녕","안녕1"));
        dataList.add(new CardItem("굿모닝","굿모닝2"));
        dataList.add(new CardItem("오하요","오하요3"));
        dataList.add(new CardItem("봉주르","봉주르4"));

        adapter = new Adapter(dataList);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void OnItemClicked(int position) {
        Log.d(TAG,"아이템클릭"+position);
    }

    @Override
    public void OnAddClicked(int position) {
        Log.d(TAG,"추가"+position);
        adapter.addItem(position,new CardItem("추가타이틀","추가내용"));

    }

    @Override
    public void OnDeleteClicked(int position) {
        Log.d(TAG,"삭제됨"+position);
        adapter.deleteItem(position);
    }
}
