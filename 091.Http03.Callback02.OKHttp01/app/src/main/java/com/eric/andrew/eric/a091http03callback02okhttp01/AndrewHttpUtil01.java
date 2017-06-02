package com.eric.andrew.eric.a091http03callback02okhttp01;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by eric on 03/06/2017.
 */

public class AndrewHttpUtil01 {
    public  static String sendRequestWithOkHttp(final String urlString) {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder().url(urlString).build();
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

}
