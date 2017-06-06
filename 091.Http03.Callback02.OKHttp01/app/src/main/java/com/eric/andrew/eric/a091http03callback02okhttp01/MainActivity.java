package com.eric.andrew.eric.a091http03callback02okhttp01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.string.ok;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    TextView tv;
    String urlString = "http://www.baidu.com";

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
//        request1();
        request2();
    }

    public void request1(){
        Runnable r = new Runnable() {

            @Override
            public void run() {
                AndrewHttpUtil01 andrewHttpUtil01 = new AndrewHttpUtil01();
                String s = andrewHttpUtil01.sendRequestWithOkHttp(urlString);
                showResponse(s);
            }
        };
        Thread t = new Thread(r);
        t.start();

    }

    public void request2(){

        AndrewHttpUtil02.sendRequestWithOkHttp(urlString,callback);
    }

    okhttp3.Callback callback = new okhttp3.Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

            showResponse(e.toString());
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
//            showResponse(response.body().toString());  // 不是toString
            if(response.isSuccessful()){
                Log.i("MainActivity","Succeed");
                showResponse(response.body().string());
            }else{
                Log.i("MainActivity","Error");
                showResponse(response.body().string());
            }


        }
    };



    private void showResponse(final String responseData) {

        runOnUiThread(new Runnable(){
            @Override
            public void run() {
                tv.setText(responseData);

            }
        });

    }
}
