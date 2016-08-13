package com.example.jim.mysqlandroid;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {
	private EditText et_name;
	private EditText et_age;
	private RadioButton rb_sex;
	private EditText et_id;
	SQLiteDatabase db;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_name = (EditText)findViewById(R.id.ev_name);
		et_age = (EditText)findViewById(R.id.ev_age);
		rb_sex = (RadioButton)findViewById(R.id.radio1);
		et_id = (EditText)findViewById(R.id.et_id);
		//创建数据库操作对象
		db = new DBHelper(this).getWritableDatabase();


	}

	//添加
	public void buttonInput(View view){
		String name = et_name.getText().toString();
		int age = Integer.parseInt(et_age.getText()+"");
		String sex = "男";

		if(rb_sex.isChecked()){
			sex="女";
		}
		//创建SQL语句
		String sql = "insert into teachers(name,age,sex) values('"+name+"',"+age+",'"+sex+"');";
		//实现添加功能
		db.execSQL(sql);
		//提示
		Toast.makeText(this, "添加成功", 0).show();
	}
	//删除
	public void buttonDelete(View view){
		//获取编号
		int id = Integer.parseInt(et_id.getText()+"");
		//创建SQL语句
		String sql = "delete from teachers " + "where _id="+id;
		//实现删除功能
		db.execSQL(sql);
		//提示
		Toast.makeText(this, "删除成功", 0).show();

	}

}

