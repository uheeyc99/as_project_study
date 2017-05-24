package com.hello.andrew.eric.a063viewfilpper01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.vflipper0);
        viewFlipper.startFlipping();
    }
}
