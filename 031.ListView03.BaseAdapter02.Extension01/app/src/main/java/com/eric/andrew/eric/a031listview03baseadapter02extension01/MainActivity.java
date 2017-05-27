package com.eric.andrew.eric.a031listview03baseadapter02extension01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.listview01);
        BaseAdapter baseAdapter = new AndrewBaseAdapter(this,get_date(),getLayoutInflater());
        listView.setAdapter(baseAdapter);
        listView.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,"a",Toast.LENGTH_SHORT).show();

        }
    };

    private List<Map<String,Object>> get_date(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> map;


        map = new HashMap<String, Object>();
        map.put("img",R.mipmap.ic_launcher);
        map.put("title","T1");
        map.put("content","c1");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img",R.mipmap.ic_launcher);
        map.put("title","T2");
        map.put("content","c2");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img",R.mipmap.ic_launcher);
        map.put("title","T3");
        map.put("content","c3");
        list.add(map);

        return list;



    }
}
