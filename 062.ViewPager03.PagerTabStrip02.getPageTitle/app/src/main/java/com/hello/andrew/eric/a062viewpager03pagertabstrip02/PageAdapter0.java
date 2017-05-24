package com.hello.andrew.eric.a062viewpager03pagertabstrip02;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
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
        vholder.context= holder.context;
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
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("" + vholder.tlist.get(position));
        Drawable drawable;

        drawable = vholder.context.getResources().getDrawable(R.drawable.launch);

        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        ImageSpan imageSpan  = new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.GREEN);
        spannableStringBuilder.setSpan(imageSpan,0,1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(1.2f),1,spannableStringBuilder.length(),spannableStringBuilder.SPAN_EXCLUSIVE_INCLUSIVE);

        return spannableStringBuilder;
    }
}
