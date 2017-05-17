package com.andrew.eric.a011handler01;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

import android.util.Log;

public class TestService01 extends Service {
    private String tag = "TestService01";
    private EricHander hander01;//一个线程可以有多个Handler，但是只能有一个Looper ！

    public TestService01() {

        Log.i(tag,"TestService01()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(tag,"onBind()");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.i(tag,"onCreate()");
        Looper looper= Looper.getMainLooper();
        hander01= new EricHander(looper);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {

        Message msg01;

        msg01 = hander01.obtainMessage();
        msg01.what = 5;
        hander01.sendMessageDelayed(msg01,1000);
        Log.i(tag,startId +" " + Thread.currentThread().getId()+ " message " + msg01.what+" sent");

        msg01 = hander01.obtainMessage();
        msg01.what = 6;
        hander01.sendMessage(msg01);
        Log.i(tag,startId +" " + Thread.currentThread().getId()+ " message " + msg01.what+" sent");

        return super.onStartCommand(intent, flags, startId);
    }

    private class EricHander extends Handler{
        public EricHander(Looper looper){
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {

            Log.i(tag,Thread.currentThread().getId()+ " message " + msg.what);
            super.handleMessage(msg);
        }
    }

}
