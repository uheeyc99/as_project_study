package com.hello.andrew.eric.a062viewpager01basic;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by eric on 23/05/2017.
 * 必须重写如下四个函数
 */

public class PagerAdapter01 extends PagerAdapter {
    List<View> list;
    public PagerAdapter01(List<View> viewList) {
        super();
        list = viewList;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        container.addView(list.get(position));
        return  list.get(position);  //isViewFromObject中的 arg1
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(list.get(position));
    }
}
