package com.example.retrofit2practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dev-openapi.kbstar.com:8443/hackathon/getAccountBalance")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestService restService = retrofit.create(RestService.class);

        Call<User> call = restService.getUser("test123");
       /* Call<Void> host2 = restService.createUser("test123@email.com",
                "password",
                "name",
        3,
        "s");*/

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.println("onFailure");

            }
        });
    }
}
