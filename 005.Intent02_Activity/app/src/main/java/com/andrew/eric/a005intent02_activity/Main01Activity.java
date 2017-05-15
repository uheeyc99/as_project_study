package com.andrew.eric.a005intent02_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main01Activity extends AppCompatActivity {
    private static final String[]  strs = new String[] {"进入另一个Activity","进入另一个Activity并传递参数","第三行","第四行"};
    ListView listView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);

        ListAdapter listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                strs);

        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    Intent intent0 = new Intent(Main01Activity.this,Main02Activity.class);
                    startActivity(intent0);
                    break;
                case 1:
                    Intent intent1 = new Intent(Main01Activity.this,Main03Activity.class);
                    intent1.putExtra("key","123");
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(Main01Activity.this,Main04Activity.class);
                    startActivityForResult(intent2,2);
                default:
                    break;

            }
        }
    };

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
//        super.onActivityReenter(resultCode, data);
        TextView textView1 =(TextView) findViewById(R.id.textView01);
        Bundle bundle;
        if(resultCode == 2){
            bundle=data.getExtras();
            String string = bundle.getString("result1");
            textView1.setText("result"+" " + string);
        }
    }
}
