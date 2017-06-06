package com.eric.andrew.eric.a008broadcastreceiver04forceoff01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AndrewBaseActivity extends AppCompatActivity {
    ForceOfflineReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndrewActivityCollector.addActivity(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("offline");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AndrewActivityCollector.removeActivity(this);
    }




    public class ForceOfflineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, final Intent intent) {
            String action = intent.getAction();
            if(action == "offline"){

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("通知");
                builder.setCancelable(false);
                builder.setMessage("您的账号在别处登录，您被迫下线");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AndrewActivityCollector.finishAll();
                        Intent intent1 = new Intent();
                        intent1.setClass(context,LoginActivity.class);
                        context.startActivity(intent1);
                    }
                });
                builder.show();


            }
        }
    }

}
