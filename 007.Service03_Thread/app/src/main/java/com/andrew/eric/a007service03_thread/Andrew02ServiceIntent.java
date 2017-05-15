package com.andrew.eric.a007service03_thread;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Andrew02ServiceIntent extends IntentService //本线程执行完所有排队操作后退出
{
	//private static String TAG = "ServiceIntent";
	private static String TAG = "Andrew02Service";
	public Andrew02ServiceIntent()
	{
		
		//Log.i(TAG, "onCreate");
		super("Andrew02ServiceIntent");    //创建线程时执行
		Log.i(TAG,"Andrew02ServiceIntent");
	}
	
	@Override
	protected void onHandleIntent(Intent intent)//每次点击事件后排队执行
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onHandleIntent"+"ID: " + Thread.currentThread().getId()+ "响应按钮");

		Log.i(TAG, "执行完成一次点击");
	}	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onStartCommand");//每次点击事件时执行
		return super.onStartCommand(intent, flags, startId);
	}	
	
	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onCreate"); //创建线程时执行
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId)
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onStart");   //每次点击事件时执行
		super.onStart(intent, startId);
	}



	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onDestroy  执行完队列中所有点击操作，销毁线程");
		super.onDestroy();
	}



}
