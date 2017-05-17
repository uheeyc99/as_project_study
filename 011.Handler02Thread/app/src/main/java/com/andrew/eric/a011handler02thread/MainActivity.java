package com.andrew.eric.a011handler02thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final static String tag = "MainActivity";
    Button btn1;
    EricHander hander01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(listener);
        hander01 = new EricHander();
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new EricThread().start();
        }
    };

    public class EricThread extends Thread{
        @Override
        public void run() {
            super.run();
            //此处处理一些耗时的工作
            Message message01 = hander01.obtainMessage();
            message01.what = 5;
            hander01.sendMessage(message01);
            Log.i(tag,"EricThread off");
        }
    }
    public class EricHander extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //主线程异步接收到message，此处进行处理
            Log.i(tag,"message: " + msg.what);
        }
    }
}
