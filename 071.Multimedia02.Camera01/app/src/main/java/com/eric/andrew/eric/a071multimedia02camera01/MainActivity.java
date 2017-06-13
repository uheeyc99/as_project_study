package com.eric.andrew.eric.a071multimedia02camera01;

import android.Manifest;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity extends Activity {
    Button takePhoto,chosePhoto;
    Uri imageUri;
    ImageView picture;
    final int TAKE_PHOTO = 1;
    final int CHOOSE_PHOTO = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takePhoto = (Button) findViewById(R.id.button01);
        chosePhoto = (Button) findViewById(R.id.button02);
        picture = (ImageView) findViewById(R.id.imageView);
        takePhoto.setOnClickListener(listener1);
        chosePhoto.setOnClickListener(listener2);
    }
    View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            File outputImage = new File(getExternalCacheDir(),"output_image.jpg");
            try {
                if(outputImage.exists()){
                    outputImage.delete();
                }
                if(false) outputImage.createNewFile(); //我觉得这句不要用

            }catch (IOException e){
                e.printStackTrace();
            }

            if(Build.VERSION.SDK_INT >= 24){
                imageUri = FileProvider.getUriForFile(MainActivity.this,
                        "com.eric.andrew.eric.a071multimedia01camera01.fileprovider",
                        outputImage);
            }else{

                imageUri = Uri.fromFile(outputImage);

            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
            startActivityForResult(intent,TAKE_PHOTO);

        }
    };

    View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }else{
                openAlbum();
            }
        }
    };
    private void openAlbum(){
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "退出了 "+ requestCode + " " + resultCode, Toast.LENGTH_SHORT).show();

        switch (requestCode){
            case TAKE_PHOTO:
                File file = new File(getExternalCacheDir(),"output_image.jpg");
                if(file.exists()) {
                    Toast.makeText(this, "缓存文件存在", Toast.LENGTH_SHORT).show();
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(this, "缓存文件不存在", Toast.LENGTH_SHORT).show();
                }
                break;
            case CHOOSE_PHOTO:

                if(Build.VERSION.SDK_INT >=19){
                    handleImageOnKitKat(data);
                }else{
                    handleImageBeforeKitKat(data);
                }
                break;

        }

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void handleImageOnKitKat(Intent data){
        String imagePath =null;
        Uri uri = null;
        if(data ==null){  //added by gaowei
            Log.i("AAAAA","no data");
            return;
        }else {
            uri = data.getData();
        }
        if(DocumentsContract.isDocumentUri(this,uri)){
            //如果是document类型的Uri，则通过Document id处理
            String docID = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())){
                Log.i("AAAAA","1");


                String id = docID.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id; //解析出数字格式id
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);

            }else
            if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Log.i("AAAAA","2");

                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docID));
                imagePath = getImagePath(contentUri,null);
            }

        }else if("content".equalsIgnoreCase(uri.getScheme())){
            //如果是content类型的Uri，则用普通方式处理
            imagePath= getImagePath(uri,null);
            Log.i("AAAAA","3");

        }else if("file".equalsIgnoreCase(uri.getScheme())){
            //如果是file类型的Uri,直接获取图片路径即可
            imagePath=uri.getPath();
        }
        displayImage(imagePath);


    }

    private void handleImageBeforeKitKat(Intent data){
        Uri uri =data.getData();
        String imagePath = getImagePath(uri,null);
        displayImage(imagePath);

    }

    private String getImagePath(Uri uri,String selection){
        String path = null;
        //通过Uri和selection来获取真实图片路径
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath){
        if(imagePath !=null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            picture.setImageBitmap(bitmap);
        }else{
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }

    }

}

