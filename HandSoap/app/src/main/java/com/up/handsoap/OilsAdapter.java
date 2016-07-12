package com.up.handsoap;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 被點選時標注顏色
 * Created by ursalahsu on 2016/7/12.
 */
public class OilsAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ListView listView;
    List<String> oils;

    public OilsAdapter(Context context,ListView listView, String[] oils) {
        this.inflater=LayoutInflater.from(context);
        this.listView=listView;
        this.oils= Arrays.asList(oils);
    }

    @Override
    public int getCount() {
        return oils.size();
    }

    @Override
    public Object getItem(int position) {
        return oils.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = (TextView) inflater.inflate(
                    android.R.layout.simple_expandable_list_item_1, parent,
                    false);
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(oils.get(position));
        updateBackground(position , textView);
        return textView;
    }
    //改變點選時的背景顏色
    public void updateBackground(int position, View view) {
        int backgroundColor;
        if (listView.isItemChecked(position)) {
            backgroundColor= Color.RED;
        } else {
            backgroundColor = Color.BLACK;
        }
        view.setBackgroundColor(backgroundColor);
    }
}
