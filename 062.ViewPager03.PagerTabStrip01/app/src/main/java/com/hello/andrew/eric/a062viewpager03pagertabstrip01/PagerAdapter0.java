package com.hello.andrew.eric.a062viewpager03pagertabstrip01;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by eric on 24/05/2017.
 */

public class PagerAdapter0 extends PagerAdapter {
    List<View> vlist;
    List<String>    tList;
    public PagerAdapter0(List<View> v,List<String> t) {
        vlist = v;
        tList = t;
    }

    @Override
    public int getCount() {
        return vlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        container.addView(vlist.get(position));
        return  vlist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(vlist.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return tList.get(position).toString();
    }
}
