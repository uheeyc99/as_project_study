package com.eric.andrew.eric.a009sharedpreferences01;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends Activity {
    Button button01,button02;
    SharedPreferences pref00;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button01.setOnClickListener(listener01);
        button02.setOnClickListener(listener02);

        pref00 = getSharedPreferences("data",MODE_PRIVATE);
        pref00.registerOnSharedPreferenceChangeListener(listener00);
    }


    View.OnClickListener listener01 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //写入数据
            SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
            editor.putString("name","Tom");
            editor.putInt("age",new Random().nextInt(99));
            editor.putBoolean("married",true);
            editor.apply();// commit   remove clear

            //getPreferences(MODE_PRIVATE)相当于getSharedPreferences("MainActivity",MODE_PRIVATE)
        }
    };


    View.OnClickListener listener02 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //读出数据
            SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
            String name = pref.getString("name","");
            int age = pref.getInt("age",0);
            Boolean married = pref.getBoolean("married",false);
            String sex = pref.getString("sex","male");
            Log.d("AndrewActivity","" +name + " " + age + " " + married+" "+sex);

        }
    };



    SharedPreferences.OnSharedPreferenceChangeListener listener00 =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                //数据发生变化时
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

                    if("age" == key){
                        Log.d("AndrewActivity",
                                "age has modified to " + sharedPreferences.getInt(key,0));
                    }

                }
            };

}
