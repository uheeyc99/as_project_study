package com.eric.andrew.eric.a031listview02simpleadapter01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SimpleAdapter simpleAdapter;
    Map<String,Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview01);
        List<Map<String,Object>> list = get_data();
        int resource = R.layout.item;
        String[] from = new String[]{"title","logo","content"};
        int[] to = new int[]{R.id.title,R.id.imageView,R.id.text_content};

        simpleAdapter = new SimpleAdapter(this,
                get_data(),
                R.layout.item,
                from,
                to);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(listener);
    }

    private List<Map<String,Object>> get_data() {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        HashMap<String,Object> map;

        map = new HashMap<String, Object>();
        map.put("logo",R.mipmap.ic_launcher_round);
        map.put("title","Lao Wang");
        map.put("content","1111111111111111111111111111111111111111111111111");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo",R.mipmap.ic_launcher);
        map.put("title","LaoLi");
        map.put("content","2222222222222222222222222222222222222222222222222");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo",R.mipmap.ic_launcher_round);
        map.put("title","Xiao Guo");
        map.put("content","33333333333333333333333333333333333333333333333");
        list.add(map);

        return list;
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,"you clicked " + position,Toast.LENGTH_SHORT).show();
        }
    };
}
