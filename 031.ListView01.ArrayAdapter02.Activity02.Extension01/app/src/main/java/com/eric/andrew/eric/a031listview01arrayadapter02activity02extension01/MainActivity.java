package com.eric.andrew.eric.a031listview01arrayadapter02activity02extension01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private String[] strings = new String[]{"1","2","3","4"};
    ListView listView0;
    ListAdapter listAdapter0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView0 = (ListView)findViewById(R.id.listview0);


        listAdapter0 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                strings);

        listView0.setAdapter(listAdapter0);
        listView0.setOnItemClickListener(listener);

    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,"clicked " + position,Toast.LENGTH_SHORT).show();
        }

    };
}
