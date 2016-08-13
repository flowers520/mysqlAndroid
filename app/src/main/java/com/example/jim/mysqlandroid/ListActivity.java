package com.example.jim.mysqlandroid;

import java.util.ArrayList;
import java.util.Currency;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ListView;

public class ListActivity extends Activity {

	ListView lv_view;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		//获取界面的listview
		lv_view = (ListView)findViewById(R.id.lv_view);


		//创建数据库操作对象
		db = new DBHelper(this).getWritableDatabase();
		Cursor cur = db.query("teachers",//table表名
				null,//columns列名, null指所有列
				null,// selection查询条件，null没有条件
				null, //条件值， null无条件值
				null, //groupby分组
				null, //having分组条件
				null);//orderBy排序

		//声明一个集合放所有的老师
		ArrayList<teachers> arr = new ArrayList<teachers>();

		//循环游标对象的数据进行一行一行的查询
		while(cur.moveToNext()){
			//获取游标内的每一个值
			int id = cur.getInt(0);//编号
			String name = cur.getString(1);
			String sex = cur.getString(2);
			int age = cur.getInt(3);
			//封装数据将查到的四份数据保存到老师对象内
			teachers t = new teachers(id, name, sex, age);
			//将老师加入集合内
			arr.add(t);
		}

		//关闭游标
		cur.close();


		//创建适配器
		teachersAdapter adapt = new teachersAdapter();
		adapt.arr = arr;
		adapt.ctx = this;

		lv_view.setAdapter(adapt);

	}


}
