package com.example.eric.a101umeng01push01;

import android.app.Application;
import android.util.Log;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by eric on 2017/7/28.
 */

public class MyApplication extends Application{
    PushAgent mPushAgent;
    @Override
    public void onCreate() {
        super.onCreate();
        mPushAgent = PushAgent.getInstance(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                mPushAgent.register(new IUmengRegisterCallback() {
                    @Override
                    public void onSuccess(String s) {
                        Log.d("mytoken",s);
                        Log.d("getRegistrationId",mPushAgent.getRegistrationId());
                    }

                    @Override
                    public void onFailure(String s, String s1) {

                    }
                });
            }
        }).run();

    }
}
