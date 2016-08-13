package com.example.jim.mysqlandroid;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RootDBHelper extends SQLiteOpenHelper{

    //通过构造函数完成建库操作
    public RootDBHelper(Context context) {
        super(context, "root.db", null, 1);
    }
    //通过create方法完成建表操作
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table roots(" + "_id integer primary key autoincrement," +
        " name varchar(10),sex varchar(1),bodyPrice integer,height double,country varchar(10),mk varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
