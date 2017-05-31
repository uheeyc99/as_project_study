package com.eric.andrew.eric.a007service02boundservice01extendingthebinderclass01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/*
* file:///Users/eric/Library/Android/sdk/docs/guide/components/bound-services.html#Binder
* */
public class MyService01 extends Service {
    AndrewBinder01 andrewBinder01= new AndrewBinder01();


    /*
    * a.
    * 1.contains public methods that the client can call
    * 2.returns the current Service instance, which has public methods the client can call
    * */
    public class AndrewBinder01 extends Binder{

        MyService01 getService(){
            return  MyService01.this;
        }
    }
    /*
    *  b.Return this instance of Binder from the onBind() callback method.
    *
    * */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return andrewBinder01;
    }
}
