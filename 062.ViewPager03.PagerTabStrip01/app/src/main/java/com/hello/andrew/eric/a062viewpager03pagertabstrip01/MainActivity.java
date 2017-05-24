package com.hello.andrew.eric.a062viewpager03pagertabstrip01;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    View page01,page02,page03;
    ViewPager viewPager;
    List<View> viewList;
    List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        page01 = inflater.inflate(R.layout.page01,null);
        page02 = inflater.inflate(R.layout.page02,null);
        page03 = inflater.inflate(R.layout.page03,null);
        viewList = new ArrayList<View>();
        viewList.add(page01);
        viewList.add(page02);
        viewList.add(page03);

        titleList = new ArrayList<String>();
        titleList.add("a");
        titleList.add("s");
        titleList.add("d");


        PagerAdapter0 pagerAdapter0 = new PagerAdapter0(viewList,titleList);
        viewPager = (ViewPager) findViewById(R.id.viewpager0);
        viewPager.setAdapter(pagerAdapter0);



    }
}
