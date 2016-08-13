package com.example.jim.mysqlandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class DBHelper extends SQLiteOpenHelper{


	//通过构造函数完成操作
	public DBHelper(Context context) {
		super(context, "student.db", null,
				1);
		// TODO Auto-generated constructor stub
	}

	//通过Create方法完成建表操作
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL("create table teachers("+
				" _id integer primary key autoincrement,"+
				" name varchar(10), sex char(2),"+
				"age integer)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}

