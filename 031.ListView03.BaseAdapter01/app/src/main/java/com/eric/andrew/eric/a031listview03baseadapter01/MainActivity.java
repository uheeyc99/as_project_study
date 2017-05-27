package com.eric.andrew.eric.a031listview03baseadapter01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.list0);
        MyAdapter adapter = new MyAdapter(get_date(),this);

        listView.setAdapter(adapter);

    }

    private List<Map<String,Object>> get_date() {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        HashMap<String,Object> map;

        map = new HashMap<String, Object>();
        map.put("title","T1");
        map.put("img",R.mipmap.ic_launcher);
        map.put("content","aaaaa1");
        list.add(map);


        map = new HashMap<String, Object>();

        map.put("title","T2");
        map.put("img",R.mipmap.ic_launcher);
        map.put("content","aaaaa2");
        list.add(map);

        return list;
    }
}
