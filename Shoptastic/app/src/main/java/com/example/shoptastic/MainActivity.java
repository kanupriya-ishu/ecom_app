package com.example.shoptastic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout menFashion = findViewById(R.id.men_fashion);

        menFashion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent attractionsIntent = new Intent(MainActivity.this, MenFashionActivity.class);

                // Start the new activity
                startActivity(attractionsIntent);
            }
        });

        RelativeLayout womenFashion = findViewById(R.id.women_fashion);

        womenFashion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent attractionsIntent = new Intent(MainActivity.this, WomenFashionActivity.class);

                // Start the new activity
                startActivity(attractionsIntent);
            }
        });

        RelativeLayout smartphones = findViewById(R.id.mobile);

        smartphones.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent attractionsIntent = new Intent(MainActivity.this, SmartphoneActivity.class);

                // Start the new activity
                startActivity(attractionsIntent);
            }
        });

        RelativeLayout books = findViewById(R.id.books);

        books.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent attractionsIntent = new Intent(MainActivity.this, BooksActivity.class);

                // Start the new activity
                startActivity(attractionsIntent);
            }
        });


    }
}