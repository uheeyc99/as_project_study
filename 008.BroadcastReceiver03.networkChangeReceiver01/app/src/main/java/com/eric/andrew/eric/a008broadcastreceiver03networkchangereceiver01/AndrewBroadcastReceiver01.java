package com.eric.andrew.eric.a008broadcastreceiver03networkchangereceiver01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by eric on 06/06/2017.
 */

public class AndrewBroadcastReceiver01 extends BroadcastReceiver{
    private final String TAG = "Receiver01";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG,"action = " + action);
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isAvailable()){
            Log.d(TAG,"network is avaliable ");
        }else{
            Log.d(TAG,"network is unavaliable ");
        }

    }
}
