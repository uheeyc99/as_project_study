package com.eric.andrew.eric.a081widgets12spinner01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner01;
    List<String> list;
    ArrayAdapter arrayAdapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView) findViewById(R.id.textView01);

        spinner01 = (Spinner) findViewById(R.id.spinner01);
        list = new ArrayList<String>();
        list.add("深圳");
        list.add("厦门");
        list.add("福州");
        list.add("弗拉迪沃斯拓客");
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner01.setAdapter(arrayAdapter);
        spinner01.setOnItemSelectedListener(listener01);
        spinner01.setOnTouchListener(tListener01);
        spinner01.setOnFocusChangeListener(fListener01);

    }




    AdapterView.OnItemSelectedListener listener01 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("你选择了： " + list.get(position).toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("None");
        }
    };

    View.OnTouchListener tListener01 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();

            return false;
        }
    };

    View.OnFocusChangeListener fListener01 = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();

        }
    };


}
