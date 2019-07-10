package com.example.retrofit2test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.getData("1").enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.isSuccessful()){
                    Data body = response.body();
                    if(body != null){
                        textView.setText(body.getUserId()+"\n");
                        textView.append(body.getId()+"\n");
                        textView.append(body.getTitle()+"\n");
                        textView.append(body.getCompleted());
                        Log.d("data.getUserId() : ",body.getUserId()+"\n");
                        Log.d("data.getId() : ",body.getId()+"\n");
                        Log.d("data.getTitle() : ",body.getTitle()+"\n");
                        Log.d("data.getCompleted() : ",body.getCompleted());
                    }
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });

    }
}
