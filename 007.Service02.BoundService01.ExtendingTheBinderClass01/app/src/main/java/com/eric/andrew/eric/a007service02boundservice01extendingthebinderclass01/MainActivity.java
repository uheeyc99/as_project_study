package com.eric.andrew.eric.a007service02boundservice01extendingthebinderclass01;

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
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(listener1);
        btn2.setOnClickListener(listener2);


    }



    View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

}
