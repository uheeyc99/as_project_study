package com.andrew.eric.a011handler01;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    String tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= (Button)findViewById(R.id.button01);
        btn1.setOnClickListener(listener01);
    }
    View.OnClickListener listener01 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent service = new Intent(MainActivity.this,TestService01.class);
            startService(service);

        }
    };


}
