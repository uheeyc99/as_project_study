package com.eric.andrew.eric.a031listview01arrayadapter01listactivity01;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {
    private static final String[] str= new String[] {"line 1", "line 2","line 3","line 4","line 5"};
//    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main); //不调用默认布局文件,而是simple_list_item_1

        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);

        setListAdapter(listAdapter);



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,"you clicked " + position+" "+ id,Toast.LENGTH_SHORT).show();
    }
}
