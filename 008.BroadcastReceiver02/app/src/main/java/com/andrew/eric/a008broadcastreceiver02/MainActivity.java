package com.andrew.eric.a008broadcastreceiver02;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    EricReceiver rec ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(listener1);
        btn2.setOnClickListener(listener2);
        btn3.setOnClickListener(listener3);

        rec = new EricReceiver("fantastic");

        Intent service = new Intent(MainActivity.this,MyService.class);
        startService(service);

    }

    View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //注册
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ERIC_ACTIPON_02");
            registerReceiver(rec,intentFilter);
        }
    };
    View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //注销
            unregisterReceiver(rec);
        }
    };
    View.OnClickListener listener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent();
            intent1.setAction("ERIC_ACTIPON_02");
            sendBroadcast(intent1);

            Intent intent2 = new Intent();
            intent2.setAction("ERIC_ACTIPON_03");
            sendBroadcast(intent2);

        }
    };
}
