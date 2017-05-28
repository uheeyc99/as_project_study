package com.eric.andrew.eric.a081widgets07imagebutton01;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

/*
Imagebutton 继承 Imageview，就是用一个图标代表了一些文字，它没Android:text属性。它由Android:src指定图标的位置
        android:src="@drawable/back"
        Button 继承 Textview,所以TextView的一些属性也适用于Button控件。

        Button把图片当作背景与放在ImageButton/ImageView中的效果是不一样的。*/


public class MainActivity extends AppCompatActivity {
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imageButton = (ImageButton) findViewById(R.id.imageButton1);
        imageButton.setOnClickListener(listener);


    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this," " + v.getId(),Toast.LENGTH_SHORT).show();
        }
    };

    public void eric_click(View view){
        ImageButton btn = (ImageButton) view;
        Toast.makeText(MainActivity.this,"aa " +btn.getId(),Toast.LENGTH_SHORT).show();

    }

}
