package com.andrew.eric.a007service03_thread;

import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button01);
        btn2 = (Button) findViewById(R.id.button02);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        Intent intent= new Intent();

        @Override
        public void onClick(View v) {
            Button btn= (Button) v;
            switch(btn.getId()){
                case R.id.button01:
                    intent.setClass(MainActivity.this,Andrew01Service.class);
                    startService(intent);
                    break;

                case R.id.button02:
                    intent.setClass(MainActivity.this,Andrew02ServiceIntent.class);
                    startService(intent);
                    break;
            }
        }
    };
}
