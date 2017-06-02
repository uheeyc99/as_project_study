package com.eric.andrew.eric.a091http03callback01httpurlconnection01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/*
* AndrewHttpUtil01 单独起了个线程获取网络数据
* AndrewHttpUtil02 做了callback
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    TextView tv;
    String address = "http://www.baidu.com";
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

//        runRequest1();
        runRequest2();
    }

    public void runRequest1(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                AndrewHttpUtil01 httpUtil01 = new AndrewHttpUtil01();
                String res = httpUtil01.sendHttpRequest(address);
                showResponse(res);
            }
        };
        Thread s = new Thread(r);
        s.start();
    }

    private void runRequest2(){
        //sendHttpRequest 为static方法，所以无需本类的对象即可调用此方法
        AndrewHttpUtil02.sendHttpRequest(address,listener);
    }



    HttpCallbackListener listener = new HttpCallbackListener() {
        @Override
        public void onFinish(String response) {
            Log.i("MainActivity","http ok");
            showResponse(response);
        }

        @Override
        public void onError(Exception e) {
            Log.i("MainActivity","http Error");
            showResponse(e.toString());
        }
    };


    public interface HttpCallbackListener{
        void onFinish(String response);
        void onError(Exception e);
    }

    void showResponse(final String response){
        Runnable r = new Runnable(){

            @Override
            public void run() {
                tv.setText(response);
            }
        };

        runOnUiThread(r);   //没有.start哟
    }

}
