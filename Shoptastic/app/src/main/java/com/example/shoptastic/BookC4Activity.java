package com.example.shoptastic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookC4Activity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    BookAdapter4 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book4);

        modelList = new ArrayList<>();
        modelList.add(new Model(getString(R.string.bookt14), getString(R.string.bookd14), R.drawable.book14));
        modelList.add(new Model(getString(R.string.bookt15), getString(R.string.bookd15), R.drawable.book15));
        modelList.add(new Model(getString(R.string.bookt16), getString(R.string.bookd16), R.drawable.book16));
        modelList.add(new Model(getString(R.string.bookt17), getString(R.string.bookd17), R.drawable.book17));
        modelList.add(new Model(getString(R.string.bookt18), getString(R.string.bookd18), R.drawable.book18));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new BookAdapter4(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}