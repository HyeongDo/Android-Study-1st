package example.com;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HttpAsyncTask().execute("https://goo.gl/eIXu91");
    }

    private static class HttpAsyncTask extends AsyncTask<String, Void, List<Weather>>{
        OkHttpClient client = new OkHttpClient();

        @Override
        protected void onPostExecute(List<Weather> weatherList) {
            super.onPostExecute(weatherList);
            if(weatherList != null){
                Log.d("HttpAsyncTask",weatherList.toString());
                WeatherAdapter adapter = new WeatherAdapter(weatherList);
               // mWeatherLsitView.setAdapter(adapter);
            }
        }

        @Override
        protected List<Weather> doInBackground(String... params) {
            List<Weather> weatherList = new ArrayList<>();
            String strUrl = params[0];
            try{
                Request request = new Request.Builder().url(strUrl).build();

                Response response = client.newCall(request).execute();
                JSONArray jsonArray = new JSONArray(response.body().string());
                for(int i = 0 ; i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String country = jsonObject.getString("country");
                    String weather = jsonObject.getString("weather");
                    String temperatuer = jsonObject.getString("temperatuer");
                    Weather w = new Weather(country,weather,temperatuer);
                    weatherList.add(w);
                }
                Log.d(TAG,"onCreate: "+ weatherList.toString());
            }catch (IOException e){
                e.printStackTrace();
            }catch (JSONException e){
                e.printStackTrace();
            }
            return weatherList;
        }
    }
}
