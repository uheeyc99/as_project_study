package com.hello.andrew.eric.a062viewpager01basic;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private View view01,view02,view03;
    private ViewPager viewPager;
    private List<View> viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view01 = getLayoutInflater().inflate(R.layout.page01,null);
        view02 = getLayoutInflater().inflate(R.layout.page02,null);
        view03 = getLayoutInflater().inflate(R.layout.page03,null);

        viewList = new ArrayList<View>();
        viewList.add(view01);
        viewList.add(view02);
        viewList.add(view03);

        viewPager = (ViewPager)findViewById(R.id.viewpager0);

        PagerAdapter pagerAdapter = new PagerAdapter01(viewList);
        viewPager.setAdapter(pagerAdapter);
    }
}
