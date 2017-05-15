package com.andrew.eric.a007service03_thread;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Andrew01Service extends Service   // 本线程常驻内存
{
	private static String TAG = "Andrew01Service";
	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onBind");
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) //点击事件后立即执行
	{
		// TODO Auto-generated method stub
		Log.i(TAG , "onStartCommand " + "Id: "  +  Thread.currentThread().getId());
		new MyThread().start();
		return START_STICKY;
		//return super.onStartCommand(intent, flags, startId);
	}
	
	private class MyThread extends Thread{

		
		public void run() {
			Log.i(TAG, "run"+"Id: "  +  Thread.currentThread().getId()+ "多线程并行执行操作");
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.i(TAG, "多线程并行执行操作 完成" );
		};
		
	}

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onCreate" );
		super.onCreate();
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId)
	{
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onDestroy");
		super.onDestroy();
	}
	
	
	
	
}
