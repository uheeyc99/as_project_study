package com.eric.andrew.eric.a082uiprogressdialog01;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button button01;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndrewProgressDialog();
            AndrewProgressTask();
        }
    };

    void AndrewProgressDialog(){
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("This is  progress");
        dialog.setTitle("Title");
        dialog.setCancelable(true);
        dialog.show();
    }

    void AndrewProgressTask(){
        //此处模拟耗时的操作，操作完成后调用calllback
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                andrewprogressResult.onSucceed();
            }
        }, 5000);
    }

    AndrewProgressResult andrewprogressResult = new AndrewProgressResult() {
        @Override
        public void onSucceed() {
            dialog.dismiss();
        }
    };

    public interface AndrewProgressResult{
        void onSucceed();
    }

}
