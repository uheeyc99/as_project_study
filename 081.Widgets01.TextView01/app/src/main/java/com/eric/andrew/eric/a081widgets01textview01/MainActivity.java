package com.eric.andrew.eric.a081widgets01textview01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView01);
        textView.setOnClickListener(listener01);
    }

    View.OnClickListener listener01 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            i++;
            textView.setText("you clicked " + i + " times");
        }
    };
}
