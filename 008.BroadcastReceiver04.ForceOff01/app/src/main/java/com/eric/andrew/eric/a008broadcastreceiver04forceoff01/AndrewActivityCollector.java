package com.eric.andrew.eric.a008broadcastreceiver04forceoff01;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 06/06/2017.
 */

public class AndrewActivityCollector {

    public static List<Activity> list = new ArrayList<>();

    public static void addActivity(Activity activity){
        list.add(activity);
    }

    public static void removeActivity(Activity activity){
        list.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity:list){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        list.clear();
    }
}
