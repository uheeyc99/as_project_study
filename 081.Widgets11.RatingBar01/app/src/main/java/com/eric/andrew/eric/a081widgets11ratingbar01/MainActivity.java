package com.eric.andrew.eric.a081widgets11ratingbar01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RatingBar rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rb1= (RatingBar) findViewById(R.id.ratingBar01);
//        rb2= (RatingBar) findViewById(R.id.ratingBar02);
//        rb3= (RatingBar) findViewById(R.id.ratingBar03);
        rb1.setOnRatingBarChangeListener(listener);
//        rb2.setOnRatingBarChangeListener(listener);
//        rb3.setOnRatingBarChangeListener(listener);
        Toast.makeText(MainActivity.this," " + rb1.getRating(),Toast.LENGTH_SHORT).show();


    }
     RatingBar.OnRatingBarChangeListener listener = new RatingBar.OnRatingBarChangeListener() {
         @Override
         public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

             Toast.makeText(MainActivity.this," " + rating,Toast.LENGTH_SHORT).show();

             rb1.setRating(rating);
//             rb2.setRating(rating);
//             rb3.setRating(rating);


         }
     };
}
