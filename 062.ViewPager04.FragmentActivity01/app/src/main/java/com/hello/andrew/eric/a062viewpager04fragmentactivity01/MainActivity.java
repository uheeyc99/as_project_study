package com.hello.andrew.eric.a062viewpager04fragmentactivity01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager0;
    List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Fragment>();
        list.add(new Fragment01());
        list.add(new Fragment02());
        list.add(new Fragment03());
        list.add(new Fragment04());
        list.add(new Fragment05());

        PagerAdapter pagerAdapter = new PagerAdapter0(getSupportFragmentManager(),list);

        viewPager0 = (ViewPager) findViewById(R.id.viewpager00);
        viewPager0.setAdapter(pagerAdapter);

    }
}


