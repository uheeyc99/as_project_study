package com.eric.andrew.eric.a008broadcastreceiver04forceoff01;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by eric on 06/06/2017.
 */

public class TitleLayout extends LinearLayout {


    public TitleLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.title_layout,this);
        Button btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {//由于是在onResume里注册的，所以只有一个activity能收到

                Intent intent = new Intent("offline");
                context.sendBroadcast(intent);

            }
        });


    }
}
