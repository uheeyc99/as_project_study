package com.eric.andrew.eric.a008broadcastreceiver04mybroadcastreceiver01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Context context;
    AndrewFunc func;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        func = new AndrewFunc(getApplicationContext());
        func.Registe01();
        func.Registe02();

        Button button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(listener);
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            func.send01();
            func.send01();
            func.send01();
            func.send01();
            func.send01();
            func.send02();
            func.send02();
            func.send02();
            func.send02();
            func.send02();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        func.unRegiste01();
        func.unRegiste02();

    }
}
