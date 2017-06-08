package com.eric.andrew.eric.a009sqlite03litepal01;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eric.andrew.eric.a009sqlite03litepal01.Database.Book;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

/*
*     compile 'org.litepal.android:core:1.4.1'

* */
public class MainActivity extends AppCompatActivity {
    Button button01,button02,button03,button04,button05,button06;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button03 = (Button) findViewById(R.id.button03);
        button04 = (Button) findViewById(R.id.button04);
        button05 = (Button) findViewById(R.id.button05);
        button06 = (Button) findViewById(R.id.button06);


        button01.setOnClickListener(listener01);
        button02.setOnClickListener(listener02);
        button03.setOnClickListener(listener03);
        button04.setOnClickListener(listener04);
        button05.setOnClickListener(listener05);
        button06.setOnClickListener(listener06);

    }

    View.OnClickListener listener01 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            db = LitePal.getDatabase();
        }
    };

    View.OnClickListener listener02 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Book book = new Book();
            book.setName("The Da Vinci Code");
            book.setAuthor("Dan Brown");
            book.setPages(454);
            book.setPrice(16.96);
//            book.setPress("Unknow");
            book.save();
            // 命令行用select * from Book查看

        }
    };


    View.OnClickListener listener03 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Book book = new Book();
            book.setName("The Lost Symbol");
            book.setAuthor("Dan Brown");
            book.setPages(510);
            book.setPrice(19.95);
//            book.setPress("Unknow");
            book.save();

            //由于还是上一个book对象， 所以更新了数据而不是新建了一列
            book.setPrice(10.99);
            book.save();

        }
    };

    View.OnClickListener listener04 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Book book = new Book();
            //更新的值
            book.setPrice(33.95);
            //查询条件
            book.updateAll("name = ? and author = ?","The Lost Symbol","Dan Brown");

        }
    };

    View.OnClickListener listener05 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DataSupport.deleteAll(Book.class,"price < ?","15");

        }
    };

    View.OnClickListener listener06 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            List<Book> books = DataSupport.findAll(Book.class);
            TextView textView = (TextView) findViewById(R.id.textView);
            String string= "";
            for(Book book:books){

                string = string + book.getId()
                        + ", " + book.getName()
                        + ", " + book.getAuthor()
                        + ", " + book.getPages()
                        + ", " + book.getPrice()
                        +"\n";
            }
            textView.setText(string);

        }
    };


}
