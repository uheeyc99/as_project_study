package com.andrew.eric.a005intent02_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main03Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String string = bundle.getString("key");
        textView = (TextView) findViewById(R.id.textView03);
        textView.setText(string);
    }
}
