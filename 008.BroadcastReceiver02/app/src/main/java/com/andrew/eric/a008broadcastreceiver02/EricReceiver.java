package com.andrew.eric.a008broadcastreceiver02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by eric on 2017/5/17.
 */

public class EricReceiver extends BroadcastReceiver {
    private final String tag = "EricReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(tag, "onReceive: " + intent.getAction() + " happened !  "+ context.getPackageName());
    }

    public EricReceiver(String string) {
        super();
        Log.i(tag,"EricReceiver " + string);
    }
}
