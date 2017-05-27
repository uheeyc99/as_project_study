package com.eric.andrew.eric.a031listview03baseadapter01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by eric on 26/05/2017.
 */

public class MyAdapter extends BaseAdapter {
    List<Map<String, Object>> list;
    LayoutInflater layoutInflater;

    public MyAdapter(List<Map<String, Object>> list0, Context context) {
        super();
        list = list0;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViweHolder viweHolder;

        if (null == convertView) {
            viweHolder = new ViweHolder();

            convertView = layoutInflater.inflate(R.layout.list, null);
            viweHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viweHolder.titleText = (TextView) convertView.findViewById(R.id.textViewTitle);
            viweHolder.contentText = (TextView) convertView.findViewById(R.id.textViewContent);
            convertView.setTag(viweHolder);
        } else {
            viweHolder = (ViweHolder) convertView.getTag();
        }

        viweHolder.titleText.setText(list.get(position).get("title").toString());
        viweHolder.contentText.setText(list.get(position).get("content").toString());
        viweHolder.imageView.setBackgroundResource((Integer) list.get(position).get("img"));


        return convertView;
    }
}
