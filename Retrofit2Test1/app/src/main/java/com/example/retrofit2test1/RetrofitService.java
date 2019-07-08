package com.example.retrofit2test1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    String url = "https://jsonplaceholder.typicode.com";

    @GET("/todos/{userId}")
    Call<Data> getData(@Path ("userId")String userId);
}
