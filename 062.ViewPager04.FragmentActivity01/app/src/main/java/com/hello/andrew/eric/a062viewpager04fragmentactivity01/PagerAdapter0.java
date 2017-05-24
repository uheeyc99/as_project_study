package com.hello.andrew.eric.a062viewpager04fragmentactivity01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by eric on 25/05/2017.
 */

public class PagerAdapter0 extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    FragmentManager fm;

    public PagerAdapter0(FragmentManager fm0, List<Fragment> lf) {
        super(fm0);
        fm = fm0;
        fragmentList = lf;

    }


    @Override
    public int getCount() {

        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


}
