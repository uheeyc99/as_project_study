package com.example.eric.a101umeng01push01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.umeng.message.PushAgent;

import static anet.channel.util.Utils.context;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushAgent.getInstance(context).onAppStart();
    }
}
