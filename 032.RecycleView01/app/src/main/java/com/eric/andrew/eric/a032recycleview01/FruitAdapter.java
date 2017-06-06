package com.eric.andrew.eric.a032recycleview01;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by eric on 06/06/2017.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{


        private List<MainActivity.Fruit> mFruitLisst;

        static class ViewHolder extends RecyclerView.ViewHolder{
            ImageView fruitImage;
            TextView fruitName;
            public ViewHolder(View view){
                super(view);
                fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
                fruitName = (TextView) view.findViewById(R.id.fruit_name);
            }

        }

        public FruitAdapter(List<MainActivity.Fruit> fruitList){
            mFruitLisst = fruitList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fruit_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return  holder;

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            MainActivity.Fruit fruit = mFruitLisst.get(position);
            holder.fruitImage.setImageResource(fruit.getImageId());
            holder.fruitName.setText(fruit.getName());

        }



        @Override
        public int getItemCount() {
            Log.d("BBB",String.valueOf(mFruitLisst.size()));
            return mFruitLisst.size();
        }

}
