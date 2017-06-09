package com.eric.andrew.eric.a071multimedia01notification01;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.io.File;
import java.util.Random;

public class MyIntentService extends Service {
    int notification_id = 1;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Bundle bundle = intent.getExtras();
        int which = bundle.getInt("alarm");

        switch (which){
            case 1:
                Notification1();
                break;
            case 2:
                Notification2();
                break;
            case 3:
                Notification3();
                break;

        }
        return super.onStartCommand(intent, flags, startId);
    }


    public void Notification1(){

        Intent intent1= new Intent(this,Notification01Activity.class);
        Intent intent2= new Intent(this,Notification02Activity.class);

        Intent[] intents ={intent1,intent2};
        PendingIntent pi = PendingIntent.getActivities(this,0,intents,0);

        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("标题1")
                .setContentText("单行简短内容")
                .setContentIntent(pi)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Sax.ogg")))
                .setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,"5"))
                .setLights(Color.GREEN,1000,1000) //呼吸灯闪烁
                .setAutoCancel(true)
                .setVibrate(new long[]{0,1000,1000,3000})  //震动：静止时长，震动时长，静止时长，震动时长 。。。。。
                .build();
        notification.flags=Notification.FLAG_ONLY_ALERT_ONCE;
        manager.notify(notification_id++,notification); //相同的ID只显示一次



    }



    public void Notification2(){

        Intent intent1= new Intent(this,Notification01Activity.class);
        Intent intent2= new Intent(this,Notification02Activity.class);

        Intent[] intents ={intent1,intent2};
        PendingIntent pi = PendingIntent.getActivities(this,0,intents,0);

        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("标题2")
                .setContentText("简短内容") //当通知栏空间不够时，显示此项， 否则显示 setStyle内容
                .setContentIntent(pi)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("一段文字sdsda dsads dsad dsa dsa dsad dsdfdfs dsadasdsa dsadsad  dsadas dsad d das dsa dsad  dsad dsa d dsadsad"))
                .build();
        notification.flags=Notification.FLAG_ONLY_ALERT_ONCE;
        manager.notify(notification_id++,notification);


    }
    public void Notification3(){

        Intent intent1= new Intent(this,Notification01Activity.class);
        Intent[] intents ={intent1};// 注意数据类型
        PendingIntent pi = PendingIntent.getActivities(this,0,intents,0);
        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("标题3")
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)))
                .setContentText("简短内容但由于有图片不显示")
                .setContentIntent(pi)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                .setAutoCancel(true)

                .build();
        notification.flags=Notification.FLAG_ONLY_ALERT_ONCE;
        manager.notify(notification_id++,notification);


    }

}
