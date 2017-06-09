package com.eric.andrew.eric.a071multimedia01notification01;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button01,button02,button03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button03 = (Button) findViewById(R.id.button03);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,MyIntentService.class);
        switch(v.getId()){
            case R.id.button01:
                intent.putExtra("alarm",1);
                    break;
            case R.id.button02:
                intent.putExtra("alarm",2);
                break;
            case R.id.button03:
                intent.putExtra("alarm",3);
                break;
        }
        startService(intent);
    }
}
