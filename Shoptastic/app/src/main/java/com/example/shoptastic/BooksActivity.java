package com.example.shoptastic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter4 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        RelativeLayout r1 = findViewById(R.id.bookc1);

        r1.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent1 = new Intent(BooksActivity.this, BookC1Activity.class);

                // Start the new activity
                startActivity(intent1);
            }
        });

        RelativeLayout r2 = findViewById(R.id.bookc2);

        r2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent2 = new Intent(BooksActivity.this, BookC2Activity.class);

                // Start the new activity
                startActivity(intent2);
            }
        });

        RelativeLayout r3 = findViewById(R.id.bookc3);

        r3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent3 = new Intent(BooksActivity.this, BookC3Activity.class);

                // Start the new activity
                startActivity(intent3);
            }
        });

        RelativeLayout r4 = findViewById(R.id.bookc4);

        r4.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent4 = new Intent(BooksActivity.this, BookC4Activity.class);

                // Start the new activity
                startActivity(intent4);
            }
        });
    }
}