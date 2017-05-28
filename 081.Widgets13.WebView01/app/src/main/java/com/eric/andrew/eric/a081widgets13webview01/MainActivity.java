package com.eric.andrew.eric.a081widgets13webview01;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        List<String> strings = new ArrayList<String>();
//        strings.add("1");
//        strings.add("2");
        String[] strings = new String[] {"方法1","方法2","方法2扩展"};
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent= new Intent();
            switch(position){
                case 0:
                    intent.setClass(MainActivity.this,AndrewWebView01.class);
                    startActivity(intent);
                    break;

                case 1:
                    intent.setClass(MainActivity.this,AndrewWebView02.class);
                    startActivity(intent);
                    break;

                case  2:
                    intent.setClass(MainActivity.this,AndrewWebView03.class);
                    startActivity(intent);
                    break;

                case 3:
                    break;

                default:

                    break;

            }
        }
    };

}
