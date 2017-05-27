package com.eric.andrew.eric.a031listview03baseadapter02extension01;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

/**
 * Created by eric on 27/05/2017.
 */

public class AndrewBaseAdapter extends BaseAdapter {
    List<Map<String, Object>> mapList;
    LayoutInflater inflater;
    Context context;
    public AndrewBaseAdapter(Context c,List<Map<String, Object>> list, LayoutInflater layoutInflater) {
        super();
        inflater = layoutInflater;
        mapList = list;
        context = c;

    }

    @Override
    public int getCount() {
        return mapList.size();
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
        ViewHolder viewHolder = null;

        if (null == convertView) {
            viewHolder = new ViewHolder();

            convertView = inflater.inflate(R.layout.vlist,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.titleText = (TextView) convertView.findViewById(R.id.title);
            viewHolder.contentText = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setBackgroundResource((Integer) mapList.get(position).get("img"));
        viewHolder.titleText.setText(mapList.get(position).get("title").toString());
        viewHolder.contentText.setText(mapList.get(position).get("content").toString());
        viewHolder.imageView.setOnClickListener(listener1);
        viewHolder.titleText.setOnClickListener(listener3);
        viewHolder.contentText.setOnClickListener(listener3);

        return convertView;
    }


    private void ShowInfo(){
        new AlertDialog.Builder(context)
                .setTitle("Title")
                .setMessage("message")
                .setPositiveButton("ok",listener4)
                .show();

    }


    View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context,"s",Toast.LENGTH_SHORT).show();
            ShowInfo();
        }
    };
    View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context,"d",Toast.LENGTH_SHORT).show();

        }
    };
    View.OnClickListener listener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context,"f",Toast.LENGTH_SHORT).show();

        }
    };

    DialogInterface.OnClickListener listener4 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(context,"g",Toast.LENGTH_SHORT).show();

        }
    };

}
