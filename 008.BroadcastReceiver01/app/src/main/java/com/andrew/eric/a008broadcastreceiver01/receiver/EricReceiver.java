package com.andrew.eric.a008broadcastreceiver01.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by eric on 2017/5/17.
 */

public class EricReceiver extends BroadcastReceiver {
    private final String tag = "EricReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(tag,intent.getAction()+ " happened");

        Bundle bundle = intent.getExtras();
        do {

            if (bundle == null) break;
            bundle.getString("name");
            Log.i(tag, "get data " + bundle.getString("name")+", "+bundle.getString("Gender"));

        }while(false);
    }
}
