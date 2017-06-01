package com.eric.andrew.eric.a007service01intentservice01;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by eric on 01/06/2017.
 */

public class IntentService01 extends IntentService {
    private int i =0;
    private final static String TAG="IntentService01";
    public IntentService01() {
        super("IntentService01");
        Log.i(TAG,"IntentService01");
    }

    @Override
    protected void onHandleIntent(Intent intent) {//排队执行



        Log.i(TAG,"正在执行:" + i);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i(TAG,"执行完成:"+i);
        i++;
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(TAG,"开始排队...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");

        super.onDestroy();
    }


}
