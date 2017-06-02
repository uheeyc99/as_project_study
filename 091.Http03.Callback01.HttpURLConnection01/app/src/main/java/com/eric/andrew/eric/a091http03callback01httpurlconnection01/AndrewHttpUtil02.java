package com.eric.andrew.eric.a091http03callback01httpurlconnection01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by eric on 03/06/2017.
 */

public class AndrewHttpUtil02 {
    public  static void sendHttpRequest(final String address, final MainActivity.HttpCallbackListener listener){
        new Thread(new Runnable(){
            @Override
            public void run() {
                sendHttpRequest0(address,listener);
            }
        }).start();

    }
    public static void  sendHttpRequest0(String address, MainActivity.HttpCallbackListener listener){


        HttpURLConnection connection = null;
        try{
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            InputStream in = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                response.append(line);
            }

            if(listener != null){
                listener.onFinish(response.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
            listener.onError(e);
        }
        finally {
            if(connection != null){
                connection.disconnect();
            }
        }

    }
}
