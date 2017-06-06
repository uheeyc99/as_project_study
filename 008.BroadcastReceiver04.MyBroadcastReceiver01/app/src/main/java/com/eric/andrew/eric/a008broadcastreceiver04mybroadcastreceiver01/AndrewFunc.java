package com.eric.andrew.eric.a008broadcastreceiver04mybroadcastreceiver01;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by eric on 06/06/2017.
 */

public class AndrewFunc {
    Context context;
    MyReceiver01 receiver01;
    MyReceiver02 receiver02;

    LocalBroadcastManager localBroadcastManager;


    public AndrewFunc(Context context) {
        this.context = context;
    }

    void Registe01(){
        IntentFilter intentFilter01 = new IntentFilter();
        intentFilter01.addAction("111");
        MyReceiver01 receiver01 = new MyReceiver01();
        context.registerReceiver(receiver01,intentFilter01);
    }
    void unRegiste01(){
        context.unregisterReceiver(receiver01);
    }

    void send01(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent();
                intent.setAction("111");
                context.sendBroadcast(intent);
            }
        }).start();
    }



    void Registe02(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("222");
        MyReceiver02 receiver02 = new MyReceiver02();
        localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.registerReceiver(receiver02,intentFilter);
    }
    void unRegiste02(){
        localBroadcastManager.unregisterReceiver(receiver02);
    }

    void send02(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                Intent intent= new Intent();
                intent.setAction("222");
                localBroadcastManager.sendBroadcast(intent);
            }
        }).start();

    }



}
