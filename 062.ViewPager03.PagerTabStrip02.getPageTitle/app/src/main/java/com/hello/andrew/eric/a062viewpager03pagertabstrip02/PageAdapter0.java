package com.hello.andrew.eric.a062viewpager03pagertabstrip02;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by eric on 24/05/2017.
 */

public class PageAdapter0 extends PagerAdapter {
    private vHolder vholder = new vHolder();
    public PageAdapter0(vHolder holder) {
        vholder.tlist = holder.tlist;
        vholder.vlist =holder.vlist;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        container.addView(vholder.vlist.get(position));
        return vholder.vlist.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(vholder.vlist.get(position));
    }

    @Override
    public int getCount() {
        return vholder.vlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return vholder.tlist.get(position);
    }
}
