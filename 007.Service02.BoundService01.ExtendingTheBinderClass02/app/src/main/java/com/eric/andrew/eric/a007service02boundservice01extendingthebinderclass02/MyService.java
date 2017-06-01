package com.eric.andrew.eric.a007service02boundservice01extendingthebinderclass02;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private final String TAG = "Myservice";
    IBinder iBinder = new AndrewBinder();

    String ss = "aaa";

    public MyService() {
        Log.i(TAG,"MyService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(TAG,"onBind");

        return iBinder;
    }


    public class AndrewBinder extends Binder {
        MyService getMyService(){
            Log.i(TAG,"getMyService");

            return MyService.this;
        }
    }

    String  AndrewFunction01(String str){
        Log.i(TAG,"AndrewFunction01");

        return "Hello " + str;
    }

    String  AndrewFunction02(String str){
        Log.i(TAG,"AndrewFunction02");
        ss = str;
        return str;
    }

    String  AndrewFunction03(){
        Log.i(TAG,"AndrewFunction03 "  + ss);

        return ss;
    }




}
