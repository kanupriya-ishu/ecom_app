package com.example.shoptastic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenFashionActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter2 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_fashion);

        modelList = new ArrayList<>();
        modelList.add(new Model("Casual Shirt", getString(R.string.men1), R.drawable.men1));
        modelList.add(new Model("Skinny Jeans", getString(R.string.men2), R.drawable.men2));
        modelList.add(new Model("Regular Kurta", getString(R.string.men3), R.drawable.men3));
        modelList.add(new Model("Men's Polo", getString(R.string.men4), R.drawable.men4));
        modelList.add(new Model("Slim Fit Blazer", getString(R.string.men5), R.drawable.men5));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter2(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }

}