package com.eric.andrew.eric.a009fileoperation01writeread01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText editText01;
    TextView textView01;
    Button button01,button02;
    AndrewFileOperation fileOperation;
    String filename01 = "data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText01 = (EditText) findViewById(R.id.editText01);
        editText01.setSelection(editText01.length());//设置光标在文本末尾
        textView01 = (TextView) findViewById(R.id.textView01);
        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button01.setOnClickListener(listener01);
        button02.setOnClickListener(listener02);
        fileOperation = new AndrewFileOperation(getBaseContext());

    }


    View.OnClickListener listener01 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s = editText01.getText().toString();
            if(s != null) {

                fileOperation.save(filename01,s);

            }
        }
    };

    View.OnClickListener listener02 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s = fileOperation.load(filename01);
            if(s != null) {

                textView01.setText(s);


            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
