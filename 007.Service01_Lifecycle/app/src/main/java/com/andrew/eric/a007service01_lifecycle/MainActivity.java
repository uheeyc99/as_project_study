package com.andrew.eric.a007service01_lifecycle;

import android.content.Intent;
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
        btn1=(Button)findViewById(R.id.button01);
        btn2=(Button) findViewById(R.id.button02);
        btn1.setOnClickListener(l);
        btn2.setOnClickListener(l);
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn=(Button) v;
            Intent service = new Intent(MainActivity.this,MyService.class);
            switch(btn.getId()){
                case R.id.button01:
                    startService(service);
                    break;

                case R.id.button02:
                    stopService(service);
                    break;

            }
        }
    };
}
