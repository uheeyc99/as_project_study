package com.eric.andrew.eric.a030layout01sample01;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.eric.andrew.eric.a030layout01sample01.subActivity.LinearLayout01;
import com.eric.andrew.eric.a030layout01sample01.subActivity.LinearLayout02;
import com.eric.andrew.eric.a030layout01sample01.subActivity.PercentFrameLayout01;
import com.eric.andrew.eric.a030layout01sample01.subActivity.RelativeLayout01;
import com.eric.andrew.eric.a030layout01sample01.subActivity.RelativeLayout02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    String[] strings = new String[]{"LinearLayout1","LinearLayout2",
            "RelativeLayout1","RelativeLayout2",
            "percent"
            };
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null) actionBar.hide();

        list = new ArrayList<>();
        list.add("a");
        list.add("s");

        ListView listView = (ListView) findViewById(R.id.listview0);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                strings);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(listener);

    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent();
            Toast.makeText(MainActivity.this, "CCC" + String.valueOf(position), Toast.LENGTH_SHORT).show();
            switch(position){
                case 0:
                    intent.setClass(MainActivity.this,LinearLayout01.class);
                    startActivity(intent);
                    break;

                case 1:
                    intent.setClass(MainActivity.this,LinearLayout02.class);
                    startActivity(intent);
                    break;

                case 2:
                    intent.setClass(MainActivity.this,RelativeLayout01.class);
                    startActivity(intent);
                    break;

                case 3:
                    intent.setClass(MainActivity.this,RelativeLayout02.class);
                    startActivity(intent);
                    break;

                case 4:
                    intent.setClass(MainActivity.this,PercentFrameLayout01.class);
                    startActivity(intent);
                    break;

                case 5:

                    break;


            }
        }

    };

}
