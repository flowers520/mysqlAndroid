package com.example.jim.mysqlandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RootListActivity extends AppCompatActivity {

    ListView lv_rootList;
    //声明数据库操作对象
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_list);

        lv_rootList = (ListView)findViewById(R.id.lv_rootView);
        //创建数据库操作对象
        db = new RootDBHelper(this).getWritableDatabase();
        //查询数据库所有的数据
        Cursor cur = db.query("roots",
                null,
                null,
                null,
                null,
                null,
                null);
        //声明集合：储存所有信息
        ArrayList<root> arr = new ArrayList<root>();
        //循环游标对查询的数据进行一行一行的读取
        while(cur.moveToNext()){
            //获取游标内的每一个值
            int id = cur.getInt(0);
            String name = cur.getString(1);
            String sex = cur.getString(2);
            int price = cur.getInt(3);
            double height = cur.getDouble(4);
            String country = cur.getString(5);
            String beizhu = cur.getString(6);

            //封装数据将查到的数据保存至对象内
            root r = new root(id, name, sex, price, height, country, beizhu);
            //将数据加入集合里
            arr.add(r);
        }
        //关闭游标
        cur.close();

        //创建适配器
        rootAdater rada = new rootAdater();
        rada.arr = arr;
        rada.ctx = this;
        //为listview设置适配器
        lv_rootList.setAdapter(rada);
    }
}
