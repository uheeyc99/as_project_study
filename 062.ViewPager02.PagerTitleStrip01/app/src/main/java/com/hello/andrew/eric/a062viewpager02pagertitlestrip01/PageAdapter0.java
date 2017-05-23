package com.hello.andrew.eric.a062viewpager02pagertitlestrip01;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by eric on 23/05/2017.
 */

public class PageAdapter0 extends PagerAdapter {
    List<View> viewList;
    List<String> titleList;
    public PageAdapter0(List<View> a0,List<String> a1) {
        viewList = a0;
        titleList = a1;
    }


    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(viewList.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
            container.addView(viewList.get(position));
        return viewList.get(position);

    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return titleList.get(position).toString();
    }
}
