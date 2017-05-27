package com.eric.andrew.eric.a031listview01arrayadapter02activity01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    String[] string = new String[]{"line0", "line1", "line2", "line3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, string);

//        // 1.直接显示ListView
//        listView = new ListView(this);
//        listView.setAdapter(arrayAdapter);
//        setContentView(listView);


        // 2.ListView绘制在 layout中, 注意顺序
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview01);
        listView.setAdapter(arrayAdapter);

    }
}