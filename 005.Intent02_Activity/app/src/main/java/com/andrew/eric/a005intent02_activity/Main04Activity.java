package com.andrew.eric.a005intent02_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//此功能未完成
public class Main04Activity extends AppCompatActivity {
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);
        button = (Button) findViewById(R.id.button04);
        button.setOnClickListener(l);

    }
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("result1","asdf");
            setResult(2,intent);
            finish();
        }
    };
}
