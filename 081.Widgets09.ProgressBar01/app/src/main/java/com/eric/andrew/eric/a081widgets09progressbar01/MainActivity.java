package com.eric.andrew.eric.a081widgets09progressbar01;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar b1,b2;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        b1= (ProgressBar) findViewById(R.id.progressBar1);
        b2= (ProgressBar) findViewById(R.id.progressBar2);

        button.setOnClickListener(listener);
        b1.setProgress(2);
        b2.setProgress(2);



    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s = editText.getText().toString();
           int i = Integer.valueOf(s).intValue();
           // int i = Integer.getInteger(editText.getText().toString()).intValue();
            Toast.makeText(MainActivity.this,""+i,Toast.LENGTH_SHORT).show();
            b1.setProgress(i);
            b2.setProgress(i);

        }
    };
}
