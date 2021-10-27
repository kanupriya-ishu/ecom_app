package com.example.shoptastic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookC3Activity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    BookAdapter3 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3);

        modelList = new ArrayList<>();
        modelList.add(new Model(getString(R.string.bookt10), getString(R.string.bookd10), R.drawable.book10));
        modelList.add(new Model(getString(R.string.bookt11), getString(R.string.bookd11), R.drawable.book11));
        modelList.add(new Model(getString(R.string.bookt12), getString(R.string.bookd12), R.drawable.book12));
        modelList.add(new Model(getString(R.string.bookt13), getString(R.string.bookd13), R.drawable.book13));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new BookAdapter3(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}