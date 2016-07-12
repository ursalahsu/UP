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
    List<String> oils;

    public OilsAdapter(Context context, String[] oils) {
        this.inflater = LayoutInflater.from(context);
        this.oils = Arrays.asList(oils);
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
//            convertView=inflater.inflate(R.layout.oil_item, parent, false);
//            textView = (TextView) convertView.findViewById(R.id.nameTextView);
            convertView=inflater.inflate(android.R.layout.simple_list_item_multiple_choice, parent, false);
            textView = (TextView) convertView;
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(oils.get(position));
        return textView;
    }
}
