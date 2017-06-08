package com.eric.andrew.eric.a009sqlite01sqlite01;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button01,button02,button03,button04,button05;
    MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(listener1);
        button02 = (Button) findViewById(R.id.button02);
        button02.setOnClickListener(listener2);
        button03 = (Button) findViewById(R.id.button03);
        button03.setOnClickListener(listener3);
        button04 = (Button) findViewById(R.id.button04);
        button04.setOnClickListener(listener4);
        button05 = (Button) findViewById(R.id.button05);
        button05.setOnClickListener(listener5);
        dbHelper = new MyDatabaseHelper(MainActivity.this,"BookStore.db",null,3);

    }

    View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dbHelper.getWritableDatabase();
        }
    };

    View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("name","The Da Vinci Code");
            values.put("author","Dan Brown");
            values.put("pages",454);
            values.put("price",16.96);
            db.insert("Book",null,values);
            values.clear();

            values.put("name","The Lost Symbol");
            values.put("author","Dan Brown");
            values.put("pages",510);
            values.put("price",19.95);
            db.insert("Book",null,values);
            values.clear();
        }
    };

    View.OnClickListener listener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("price",10.99);
            int effect = db.update("Book",values,"name = ?", new String[]{"The Da Vinci Code"});
            Log.i("MainActivity"," update " + effect);
        }
    };

    View.OnClickListener listener4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            int effect = db.delete("Book","pages > ?", new String[]{"500"});
            Log.i("MainActivity delete"," " + effect);
        }
    };

    View.OnClickListener listener5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            Cursor cursor = db.query("Book",null,null,null,null,null,null);
            if(cursor.moveToFirst()){

                do {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String author = cursor.getString(cursor.getColumnIndex("author"));
                    int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                    double price = cursor.getDouble(cursor.getColumnIndex("price"));
                    Log.i("Query", " " +id +" "+ name +" " + author + " " + pages + " "+ price);
                }while (cursor.moveToNext());
            }
            cursor.close();

        }
    };
}
