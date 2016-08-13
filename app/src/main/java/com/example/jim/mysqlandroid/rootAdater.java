package com.example.jim.mysqlandroid;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class rootAdater extends BaseAdapter{
    ArrayList<root> arr;
    Context ctx;

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(ctx, R.layout.rootlistview, null);

        TextView id = (TextView)convertView.findViewById(R.id.tv_rootId);
        TextView name = (TextView)convertView.findViewById(R.id.tv_rootName);
        TextView sex = (TextView)convertView.findViewById(R.id.tv_rootSex);
        TextView price = (TextView)convertView.findViewById(R.id.tv_rootPrice);
        TextView height = (TextView)convertView.findViewById(R.id.tv_rootHeight);
        TextView country = (TextView)convertView.findViewById(R.id.tv_rootCountry);
        TextView beizhu = (TextView)convertView.findViewById(R.id.tv_rootBz);

        root r = arr.get(position);

        id.setText(r.id+"");
        name.setText(r.name);
        sex.setText(r.sex);
        price.setText(r.price+"");
        height.setText(r.height+"");
        country.setText(r.country);
        beizhu.setText(r.beizhu);

        return convertView;
    }
}
