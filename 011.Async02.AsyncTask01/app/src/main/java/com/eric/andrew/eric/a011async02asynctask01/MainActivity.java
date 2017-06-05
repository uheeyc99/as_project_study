package com.eric.andrew.eric.a011async02asynctask01;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AndrewDownloadTask().execute("a","s","d");
    }

    class AndrewDownloadTask extends AsyncTask<String,Integer,Boolean>{

        @Override
        protected Boolean doInBackground(String... params) {
            //耗时的任务在此执行，但是不能操作UI
            for(int i = 0;i<params.length;i++) {
                Log.i(TAG, "doInBackground " + params[i]);
                publishProgress(10,5,90);
                publishProgress(80,20,91);
                publishProgress(99,80,92);
            }


            return true;
        }

        @Override
        protected void onPreExecute() {
            //构造进度条
            super.onPreExecute();
            Log.i(TAG,"onPreExecute ");

        }



        @Override
        protected void onProgressUpdate(Integer... progress) {
            //调用publishProgress时会跳转到此处，进行UI操作
            super.onProgressUpdate(progress);
            Log.i(TAG,"onProgressUpdate " + progress[0] +" " +progress[1]+" " + progress[2]);

        }


        @Override
        protected void onPostExecute(Boolean result) {
            //销毁进度条
            super.onPostExecute(result);
            Log.i(TAG,"onPostExecute " + result);

        }

    }
}
