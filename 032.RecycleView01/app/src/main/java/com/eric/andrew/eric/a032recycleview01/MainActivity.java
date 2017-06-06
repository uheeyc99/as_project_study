package com.eric.andrew.eric.a032recycleview01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }



    private void initFruits(){
        Fruit apple =new Fruit("Apple",R.mipmap.ic_launcher_round);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana",R.mipmap.ic_launcher_round);
        fruitList.add(banana);

        fruitList.add(apple);
        fruitList.add(banana);
    }

    public class Fruit{

        private String name;
        private int imageId;

        public Fruit(String name,int imageId) {
            this.name =name;
            this.imageId=imageId;

        }

        public String getName() {
            return name;
        }

        public int getImageId() {
            return imageId;
        }

    }


}
