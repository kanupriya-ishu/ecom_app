package com.example.shoptastic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookC1Activity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    BookAdapter1 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);

        modelList = new ArrayList<>();
        modelList.add(new Model(getString(R.string.bookt1), getString(R.string.bookd1), R.drawable.book1));
        modelList.add(new Model(getString(R.string.bookt2), getString(R.string.bookd2), R.drawable.book2));
        modelList.add(new Model(getString(R.string.bookt3), getString(R.string.bookd3), R.drawable.book3));
        modelList.add(new Model(getString(R.string.bookt4), getString(R.string.bookd4), R.drawable.book4));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new BookAdapter1(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}