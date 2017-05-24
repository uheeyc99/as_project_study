package com.hello.andrew.eric.a062viewpager03pagertabstrip02;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    View page01,page02,page03;
    ViewPager viewPager;
    vHolder vHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        page01 = inflater.inflate(R.layout.page01,null);
        page02 = inflater.inflate(R.layout.page02,null);
        page03 = inflater.inflate(R.layout.page03,null);

        vHolder = new vHolder();
        vHolder.tlist = new ArrayList<String>();
        vHolder.vlist = new ArrayList<View>();


        vHolder.vlist.add(page01);
        vHolder.vlist.add(page02);
        vHolder.vlist.add(page03);

        vHolder.tlist.add("a");
        vHolder.tlist.add("s");
        vHolder.tlist.add("d");

        viewPager = (ViewPager) findViewById(R.id.viewpager0);
        PagerAdapter adapter = new PageAdapter0(vHolder);
        viewPager.setAdapter(adapter);






    }
}
