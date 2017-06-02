package com.eric.andrew.eric.a091http02okhttp03json01jsonobject01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    TextView tv;
    String urlString = "http://192.168.56.101/get_data.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendRequestWithOkHttp();

    }


    private void sendRequestWithOkHttp() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                try {
                    Request request = new Request.Builder().url(urlString).build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                    parseJSONObject(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
    }

    private void parseJSONObject(String jsonData) {
        try {
            JSONArray jsonArry = new JSONArray(jsonData);
            for(int i=0;i<jsonArry.length();i++){
                JSONObject jsonObject = jsonArry.getJSONObject(i);
                String id = jsonObject.getString("id");
                String version = jsonObject.getString("version");
                String name = jsonObject.getString("name");
                Log.i("MainActivity","id is " + id);
                Log.i("MainActivity","name is " + name);
                Log.i("MainActivity","version is " + version);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void showResponse(final String responseData) {

        runOnUiThread(new Runnable(){
            @Override
            public void run() {
                tv.setText(responseData);
            }
        });

    }
}
