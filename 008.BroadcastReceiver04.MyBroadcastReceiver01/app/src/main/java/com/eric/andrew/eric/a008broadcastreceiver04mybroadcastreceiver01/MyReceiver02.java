package com.eric.andrew.eric.a008broadcastreceiver04mybroadcastreceiver01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by eric on 06/06/2017.
 */

public class MyReceiver02 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("AREC2", intent.getAction());

    }
}
