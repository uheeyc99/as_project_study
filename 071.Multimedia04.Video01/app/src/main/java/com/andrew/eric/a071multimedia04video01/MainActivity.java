package com.andrew.eric.a071multimedia04video01;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button01,button02,button03;
    VideoView videoView;
    String[] andrewPermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
        button01 = (Button) findViewById(R.id.button11);
        button01.setOnClickListener(this);
        requestPermission();





    }
    private void requestPermission(){

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,andrewPermissions,1);

        }else{
            Log.i("andrew tag","I had permission");
            File file = new File(Environment.getExternalStorageDirectory(),"tq.mp4");
            Log.i("AAA",file.getPath());
            videoView.setVideoPath(file.getPath());
            videoView.start();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button11:
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                //Intent intent = new Intent("Intent.ACTION_GET_CONTENT");

                intent.setType("video/*");
                startActivityForResult(intent,1);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        String path=uri.getPath();
        Log.i("MainActivity",path);



        if(DocumentsContract.isDocumentUri(this,uri)){
            //如果是document类型的Uri，则通过Document id处理
            String docID = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())){
                Log.i("AAAAA","1");


                String id = docID.split(":")[1];
                Log.i("AAAAA","id =" + id);

                String selection = MediaStore.Images.Media._ID + "=" + id; //解析出数字格式id
                Log.i("AAAAA","selection="+selection);

                path = getVideoPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,selection);
                Log.i("MainActivity",path);


            }else
            if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Log.i("AAAAA","2");

                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docID));
                path = getVideoPath(contentUri,null);
            }

        }else if("content".equalsIgnoreCase(uri.getScheme())){
            //如果是content类型的Uri，则用普通方式处理
            path= getVideoPath(uri,null);
            Log.i("AAAAA","3");

        }else if("file".equalsIgnoreCase(uri.getScheme())){
            //如果是file类型的Uri,直接获取图片路径即可
            path=uri.getPath();
        }




        videoView.setVideoPath(path);
        videoView.start();

    }



    private String getVideoPath(Uri uri,String selection){
        String path = null;
        //通过Uri和selection来获取真实图片路径
        Log.i("AAAAAAAAA",uri.toString()+ " and "+selection);
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                Log.i("AAAAAAAAA","path="+path);

            }
            cursor.close();
        }
        return path;
    }
}
