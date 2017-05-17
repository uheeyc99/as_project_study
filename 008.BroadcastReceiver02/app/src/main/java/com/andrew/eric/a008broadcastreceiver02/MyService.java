package com.andrew.eric.a008broadcastreceiver02;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.IntDef;

public class MyService extends Service {
    EricReceiver rec ;
    IntentFilter intentFilter;
    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        rec = new EricReceiver("terrible");
        intentFilter = new IntentFilter();
        intentFilter.addAction("ERIC_ACTIPON_03");
        registerReceiver(rec,intentFilter);
        return super.onStartCommand(intent, flags, startId);
    }
}
