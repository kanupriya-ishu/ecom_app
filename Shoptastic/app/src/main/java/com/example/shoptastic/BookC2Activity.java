package com.example.shoptastic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookC2Activity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    BookAdapter2 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);

        modelList = new ArrayList<>();
        modelList.add(new Model(getString(R.string.bookt5), getString(R.string.bookd5), R.drawable.book5));
        modelList.add(new Model(getString(R.string.bookt6), getString(R.string.bookd6), R.drawable.book6));
        modelList.add(new Model(getString(R.string.bookt7), getString(R.string.bookd7), R.drawable.book7));
        modelList.add(new Model(getString(R.string.bookt8), getString(R.string.bookd8), R.drawable.book8));
        modelList.add(new Model(getString(R.string.bookt9), getString(R.string.bookd9), R.drawable.book9));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new BookAdapter2(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}