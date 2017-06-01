package com.eric.andrew.eric.a007service02boundservice01extendingthebinderclass01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

/*
* file:///Users/eric/Library/Android/sdk/docs/guide/components/bound-services.html#Binder
* */
public class MyService01 extends Service {

    // Binder given to clients
    IBinder MyBinder = new AndrewLocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return MyBinder;
    }

    public class AndrewLocalBinder extends Binder {

        MyService01 GetAndrewClass(){
            // Return this instance of MyService01 so clients can call public methods
            return MyService01.this;
        }
    }

    /** method for clients */
    public void AndrewFunction(){

    }
}
