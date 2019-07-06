package com.example.mycardrecycerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.ClickListener {
   private static final String TAG = MainActivity.class.getSimpleName();
   Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<CardItem> dataList = new ArrayList<>();
        dataList.add(new CardItem("첫번째제목이에용","첫번째내용이고용"));
        dataList.add(new CardItem("두번째내용이용","두번째내용이고용"));
        dataList.add(new CardItem("세번째내용이에용","세번째내용이고용"));
        dataList.add(new CardItem("네번째내용이에용","네번째내용이고용"));

        adapter = new Adapter(dataList);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClicked(int position) {
        Log.d(TAG,"아이템클릭"+position);
    }

    @Override
    public void onAddClicked(int position) {
        Log.d(TAG,"추가"+position);
        adapter.addItem(position,new CardItem("추가됨","추가됨"));
    }

    @Override
    public void onDeleteClicked(int position) {
        Log.d(TAG,"삭제"+position);
        adapter.removeItem(position);
    }
}
