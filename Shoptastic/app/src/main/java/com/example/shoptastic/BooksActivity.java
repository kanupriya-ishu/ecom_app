package com.example.shoptastic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        modelList = new ArrayList<>();
        modelList.add(new Model("The Alchemist", getString(R.string.book1), R.drawable.book1));
        modelList.add(new Model("Eleven Minutes", getString(R.string.book2), R.drawable.book2));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter4(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}