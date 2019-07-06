package com.example.retrofit2practice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestService {
    public static final String BASE_URL = "https://api.github.com";

    @GET("")
    Call<User> getUser(@Path("계좌잔액") String id);
    @GET("users/{id}/followers")
    Call<List<User>> getFollowers(@Path("id") String id);
    @GET("users/{id}/following")
    Call<List<User>> getFollowing(@Path("id") String id);

    @FormUrlEncoded
    @POST("/test")
    Call<Void> createUser(@Field("email") String email,
                          @Field("password") String password,
                          @Field("nmae") String name,
                          @Field("term_no") int term_no,
                          @Field("agree_term_version") String term_version);

    @FormUrlEncoded
    @PUT("/test")
    Call<Void> updateUser(@Field("current_password") String currentPassword,
                          @Field("password") String password);
    //@Headers("Content-Type:application/json")
    //@POST("/tracking")
    //Call<TrackingBean> saveTracking(@Body SendingBean json);


}
