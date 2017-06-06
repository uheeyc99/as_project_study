package com.eric.andrew.eric.a008broadcastreceiver03networkchangereceiver01;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    AndrewBroadcastReceiver01 andrewBroadcastReceiver01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndrewregisterReceiver();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(andrewBroadcastReceiver01);
        super.onDestroy();
    }

    void AndrewregisterReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        andrewBroadcastReceiver01 = new AndrewBroadcastReceiver01();
        registerReceiver(andrewBroadcastReceiver01,intentFilter);


    }

}
