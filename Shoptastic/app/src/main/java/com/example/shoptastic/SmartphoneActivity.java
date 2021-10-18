package com.example.shoptastic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter3 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone);

        modelList = new ArrayList<>();
        modelList.add(new Model("Samsung M52", getString(R.string.mob1), R.drawable.mobile1));
        modelList.add(new Model("Redmi 9A", getString(R.string.mob2), R.drawable.mobile2));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter3(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}