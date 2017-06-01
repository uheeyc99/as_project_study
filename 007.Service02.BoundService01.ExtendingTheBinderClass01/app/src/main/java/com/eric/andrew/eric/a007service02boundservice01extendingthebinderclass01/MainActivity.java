package com.eric.andrew.eric.a007service02boundservice01extendingthebinderclass01;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyService01 service01;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn1= (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBound)
                    service01.AndrewFunction();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(MainActivity.this,MyService01.class);
        boolean b = bindService(intent,conn,Context.BIND_AUTO_CREATE);
        //service01.AndrewFunction();//此处不能调用，因为service01可能还没准备好


    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mBound) {
            unbindService(conn);
            mBound = false;
        }
    }


    ServiceConnection conn = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService01.AndrewLocalBinder service1 = (MyService01.AndrewLocalBinder)service;
            service01 = service1.GetAndrewClass();
            mBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;

        }
    };


}
