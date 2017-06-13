package com.eric.andrew.eric.a071multimedia03audio01;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button play01,pause01,stop01;
    Button play02,pause02,stop02;
    Button choose;
    TextView textView;
    MediaPlayer mediaPlayer01=null;
    MediaPlayer mediaPlayer02=null;
    String[] andrewPermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer01 != null){
            mediaPlayer01.stop();
            mediaPlayer01.reset();
        }
        if(mediaPlayer02 != null){
            mediaPlayer02.stop();
            mediaPlayer02.release();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play01 = (Button) findViewById(R.id.play01);
        pause01 = (Button) findViewById(R.id.pause01);
        stop01 = (Button) findViewById(R.id.stop01);

        play02 = (Button) findViewById(R.id.play02);
        pause02 = (Button) findViewById(R.id.pause02);
        stop02 = (Button) findViewById(R.id.stop02);

        choose = (Button) findViewById(R.id.choose);
        textView = (TextView) findViewById(R.id.textView);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,andrewPermissions,1);

        }else{
            Log.i("andrew tag","I had permission");
        }

        play01.setOnClickListener(this);
        pause01.setOnClickListener(this);
        stop01.setOnClickListener(this);

        play02.setOnClickListener(this);
        pause02.setOnClickListener(this);
        stop02.setOnClickListener(this);

        choose.setOnClickListener(this);

    }

    private void initMediaPlayer01(){

        try {
            if(mediaPlayer01 == null) {
                File file = new File(Environment.getExternalStorageDirectory(), "/eric/mp3/映山红.mp3");
                Toast.makeText(this, "AAA "+ file.getPath(), Toast.LENGTH_SHORT).show();
                mediaPlayer01 = new MediaPlayer();
                mediaPlayer01.setDataSource(file.getPath());
                mediaPlayer01.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer01.prepare();  // block
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void initMediaPlayer02(){

        if(mediaPlayer02 == null) {

            mediaPlayer02 = MediaPlayer.create(this, R.raw.z);// no need to call prepare(); create() does that for you

        }
    }



    @Override
    public void onClick(View v) {
        initMediaPlayer01();
        initMediaPlayer02();

        switch (v.getId()){

            case R.id.play01:

                if(!mediaPlayer01.isPlaying()){
                    mediaPlayer01.start();
                }
                break;

            case R.id.pause01:
                if(mediaPlayer01.isPlaying()){
                    mediaPlayer01.pause();

                }
                break;

            case R.id.stop01:
                if(mediaPlayer01.isPlaying()){
                    mediaPlayer01.stop();
                    mediaPlayer01.release();
                    mediaPlayer01 = null;

                }
                break;

            case R.id.play02:
                if(!mediaPlayer02.isPlaying()){
                    mediaPlayer02.start();
                }
                break;

            case R.id.pause02:
                if(mediaPlayer02.isPlaying()){
                    mediaPlayer02.pause();

                }
                break;

            case R.id.stop02:
                if(mediaPlayer02.isPlaying()){
                    mediaPlayer02.stop();
                    mediaPlayer02.release();
                    mediaPlayer02 = null;
                }
                break;

            case R.id.choose:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/*");
                startActivityForResult(intent,1);
                break;


            default:
                Log.i("AAA","What the hell!");

                break;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults){
        switch(requestCode){
            case 1:
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){

            }else{
                Toast.makeText(this,"拒绝权限将无法使用程序",Toast.LENGTH_SHORT).show();
                finish();
            }
            break;
            default:
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        textView.setText(uri.toString());
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(getApplicationContext(),uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
