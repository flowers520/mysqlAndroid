package com.example.jim.mysqlandroid;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class teachersAdapter extends BaseAdapter{
	ArrayList<teachers> arr;
	Context ctx;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arr.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		arg1 = View.inflate(ctx, R.layout.teacher, null);

		TextView id = (TextView)arg1.findViewById(R.id.tv_id);
		TextView name = (TextView)arg1.findViewById(R.id.tv_name);
		TextView sex = (TextView)arg1.findViewById(R.id.tv_sex);
		TextView age = (TextView)arg1.findViewById(R.id.tv_age);

		teachers t = arr.get(arg0);

		id.setText(t._id+"");
		name.setText(t.name);
		sex.setText(t.sex);
		age.setText(t.age+"");


		return arg1;
	}

}

