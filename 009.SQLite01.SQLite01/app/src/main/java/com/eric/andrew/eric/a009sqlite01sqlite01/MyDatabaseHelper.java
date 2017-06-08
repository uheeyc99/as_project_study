package com.eric.andrew.eric.a009sqlite01sqlite01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by eric on 08/06/2017.
 * sqlite3 BookStore.db,.table,.schema
 *
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    String TAG = "MyDatabaseHelper";
    public static final String CREATE_BOOK = "create table Book("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";
    public static final String CREATE_CATEGORY = "create table Category("
            + "id integer primary key autoincrement,"
            + "category_name text"
            + "category_name integer)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Log.i(TAG,"onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //MyDatabaseHelper中version增大时，调用onUpgrade
        Log.i(TAG,"onUpgrade  version" + newVersion);
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);

    }


}
