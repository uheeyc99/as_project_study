package com.eric.andrew.eric.a081widgets04checkbox01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1,cb2,cb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb1.setOnCheckedChangeListener(listener);
        cb2.setOnCheckedChangeListener(listener);
        cb3.setOnCheckedChangeListener(listener);


    }
    CheckBox.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Toast.makeText(MainActivity.this,
                    buttonView.getText() + " "+ isChecked,
                    Toast.LENGTH_SHORT).show();
        }
    };
}
