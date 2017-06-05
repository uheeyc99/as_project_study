package com.eric.andrew.eric.a030layout01sample01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by eric on 04/06/2017.
 */

public class TitleLayout extends LinearLayout  {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context,attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.title_layout,this);

        Button btn1,btn2;
        btn1= (Button) findViewById(R.id.button00);
        btn2= (Button) findViewById(R.id.button01);
        btn1.setOnClickListener(listener1);
        btn2.setOnClickListener(listener2);
    }

    OnClickListener listener1 = new OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    OnClickListener listener2 = new OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };




}
