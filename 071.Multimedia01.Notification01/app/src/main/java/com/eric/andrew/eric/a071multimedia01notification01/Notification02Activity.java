package com.eric.andrew.eric.a071multimedia01notification01;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Notification02Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification01);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("2");
        manager.cancel(1);
        Log.d("Notification01Activity","OnCreate");

    }
}
