package com.example.rxjava_retrofit_recyclerview_cardview_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Observable;

import io.reactivex.Scheduler;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://example.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        github = new GithubClient();
        disposable = github.getApi().getRepos(OWNER)
                .subcribeOn(Scheduler.io())
                .ObserveOn(Scheduler.mainThread())
                .subscribe(item->adapter.updateItems(items));
    }




}
