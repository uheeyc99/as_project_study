package com.eric.andrew.eric.a081widgets03radiobutton01;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton rd11,rd12,rd13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rd11 = (RadioButton) findViewById(R.id.radioButton11);
        rd12 = (RadioButton) findViewById(R.id.radioButton12);
        rd13 = (RadioButton) findViewById(R.id.radioButton13);

        rg1.setOnCheckedChangeListener(listener1);


    }

    RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            RadioButton rb = (RadioButton) MainActivity.this.findViewById(checkedId);
            Toast.makeText(MainActivity.this,"radio "+rb.getText(), Toast.LENGTH_SHORT).show();
        }
    };
}
