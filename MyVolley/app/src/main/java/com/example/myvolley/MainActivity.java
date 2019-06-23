package com.example.myvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        imageView = (ImageView)findViewById(R.id.imageView);


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();


            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendImageRequest();
            }
        });


        if(AppHelper.requestQueue == null){
            AppHelper.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    };

    public void sendImageRequest(){
        String url = "https://pds.joins.com/news/component/htmlphoto_mmdata/201902/13/ae20efaa-317b-491b-ae57-d3ffffa3cce6.jpg";

        ImageLoadTask task = new ImageLoadTask(url,imageView);
        task.execute();
    }
    public void sendRequest(){
       // String url = "https://www.google.co.kr";
        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101";

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답->"+response);

                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                     println("에러->"+error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                return params;
            }
        };


        request.setShouldCache(false);
        AppHelper.requestQueue.add(request);
        println("요청 보냄.");
    }

    public void processResponse(String response){
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response,MovieList.class);

        if(movieList != null){
            int countMovie = movieList.boxOfficeResult.dailyBoxOfficeList.size();
            println("박스오피스 타입 : "+movieList.boxOfficeResult.boxofficeType);
            println("응답받은 영화 갯수 : "+countMovie);
            println("네번째 영화이름"+movieList.boxOfficeResult.dailyBoxOfficeList.get(3).movieNm);

        }
    }
    public void println(String data){
        textView.append(data+"\n");
    }
}
