package com.eric.andrew.eric.a091http02okhttp03json02gson01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    TextView tv;
    String urlString = "http://192.168.56.101/get_data.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendRequestWithOkHttp();

    }


    private void sendRequestWithOkHttp() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                try {
                    Request request = new Request.Builder().url(urlString).build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
//                    parseJSONObject(responseData);
                    parseJsonWithGson(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
    }

    private void parseJsonWithGson(String responseData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(responseData, new TypeToken<List<App>>(){}.getType());
        for(App app : appList){
            Log.i("MainActivity","id is  "+ app.getId());
            Log.i("MainActivity","name is  "+ app.getName());
            Log.i("MainActivity","version is  "+ app.getVersion());

        }
    }

    public class App{
        private String id;
        private String name;
        private String version;

        public String getId(){
            return id;
        }
        public void  setId(String id){
            this.id = id;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getVersion(){
            return  version;
        }
        public void setVersion(String version){
            this.version =version;
        }


    }


    private void showResponse(final String responseData) {

        runOnUiThread(new Runnable(){
            @Override
            public void run() {
                tv.setText(responseData);
            }
        });

    }
}
