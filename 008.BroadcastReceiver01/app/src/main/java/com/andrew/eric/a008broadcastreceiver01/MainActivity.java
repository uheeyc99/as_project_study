package com.andrew.eric.a008broadcastreceiver01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button01);
        btn1.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent1 = new Intent();
            intent1.setAction("eric_broad_action1");
            intent1.putExtra("name","Eric");
            intent1.putExtra("Gender","Male");
            sendBroadcast(intent1);

            Intent intent2 = new Intent();
            intent2.setAction("eric_broad_action2");
            intent2.putExtra("name","Jessica");
            intent2.putExtra("Gender","Female");
            sendBroadcast(intent2);


        }
    };
}
