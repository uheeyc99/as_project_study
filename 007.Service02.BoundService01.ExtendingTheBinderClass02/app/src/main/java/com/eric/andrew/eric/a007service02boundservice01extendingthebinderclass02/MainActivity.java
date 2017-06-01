package com.eric.andrew.eric.a007service02boundservice01extendingthebinderclass02;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    TextView tv1;
    EditText et1;
    MyService myService;
    boolean mb= false;
    private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et1 = (EditText) findViewById(R.id.editText);
        btn1= (Button) findViewById(R.id.button);
        tv1= (TextView) findViewById(R.id.textView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick");
               if(mb) {
                   String str = myService.AndrewFunction01(et1.getText().toString());
                   tv1.setText(str);
               }

            }
        });
        btn2 = (Button) findViewById(R.id.button2);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
        Intent intent = new Intent(MainActivity.this,MyService.class);
        bindService(intent,conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mb) {
            Log.i(TAG,"ubindServer");
            unbindService(conn);
        }
    }

    ServiceConnection conn = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG,"onServiceConnected");
            MyService.AndrewBinder binder = (MyService.AndrewBinder) service;
            myService = binder.getMyService();
            mb = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //主动调用unbindService时，不执行此处，一般是Service被Kill掉时调用
            Log.i(TAG,"onServiceDisconnected");

        }
    };


}
