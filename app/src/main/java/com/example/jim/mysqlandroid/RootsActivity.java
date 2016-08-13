package com.example.jim.mysqlandroid;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RootsActivity extends AppCompatActivity {

    //声明数据库操作对象（因为要进行数据库增加）
    SQLiteDatabase db;

    //声明控件
    private EditText et_name;
    private RadioButton button_radio;
    private EditText et_price;
    private EditText et_height;
    private EditText et_country;
    private EditText et_beizhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roots);

        //查找控件
        et_name = (EditText)findViewById(R.id.et_name);
        button_radio = (RadioButton)findViewById(R.id.radio_girl);
        et_price = (EditText)findViewById(R.id.et_price);
        et_height = (EditText)findViewById(R.id.et_height);
        et_country = (EditText)findViewById(R.id.et_country);
        et_beizhu = (EditText)findViewById(R.id.et_beizhu);

        //创建数据库操作对象
        db = new RootDBHelper(this).getWritableDatabase();
    }

    //向数据库里面插入数据
    public void buttonIn(View view){
        //获取输入的数据
        String name = et_name.getText()+"";
        String sex = "男";
        if (button_radio.isChecked()){
            sex="女";
        }
        int price = Integer.parseInt(et_price.getText()+"");
        int height = Integer.parseInt(et_height.getText()+"");
        String country = et_country.getText()+"";
        String beizhu = et_beizhu.getText()+"";

        //创建SQL语句
        String sql = "insert into roots(name,sex,bodyPrice,height,country,mk) values('"+
                name+"','"+
                sex+"',"+
                price+","+
                height+",'"+
                country+"','"+
                beizhu+"')";
        //实现添加功能
        db.execSQL(sql);
        //提示
        Toast.makeText(this,"添加成功", 0).show();
    }

    //关闭按钮
    public void buttonClose(View view){
        finish();
    }
}
