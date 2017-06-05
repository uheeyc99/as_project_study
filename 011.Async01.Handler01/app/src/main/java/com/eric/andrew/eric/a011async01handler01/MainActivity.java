package com.eric.andrew.eric.a011async01handler01;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(listener);

    }


    View.OnClickListener listener = new View.OnClickListener() {
        int i=1;
        @Override
        public void onClick(View v) {

            AndrewDownload(i);
            i++;
        }
    };

    private  void AndrewDownload(final int jj){

        new Thread(new Runnable(){
            @Override
            public void run() {
                //处理耗时任务 。。。。。
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message message = Message.obtain();
                message.what = 1;
                message.obj = "下载完成"+ jj + ";";
                handler.sendMessage(message);

            }
        }).start();

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String string = (String) msg.obj;
                    textView.setText(string);
                    break;
            }


        }
    };
}
