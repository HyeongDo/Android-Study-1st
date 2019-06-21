package example.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.MyRecyclerViewClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MyRecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<CardItem> dataList = new ArrayList<>();
        dataList.add(new CardItem("이것은 첫번째 아이템","안드로이드 보이라고 합니다"));
        dataList.add(new CardItem("이것은 두번째 아이템","두 줄 입력도 해 볼게요 \n 두 줄 입니다"));
        dataList.add(new CardItem("이것은 세번째 아이템","이번엔 세줄 \n 두번째 줄 \n 세번째 줄 입니다"));
        dataList.add(new CardItem("이것은 네번째 아이템","잘 되네요"));

        mAdapter = new MyRecyclerAdapter(dataList);
        mAdapter.setOnClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClicked(int position) {
        Log.d(TAG,"onItemClicked"+position);
    }

    @Override
    public void onShareButtonClicked(int position) {
        Log.d(TAG,"onSharedButtonClicked"+position);
        mAdapter.addItem(position,new CardItem("추가 됨","추가 됨"));
    }

    @Override
    public void onLearnMoreButtonClicked(int position) {
        Log.d(TAG,"onLearnMoreClicked"+position);
        mAdapter.removeItem(position);
    }
}
