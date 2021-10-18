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
    boolean menActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_fashion);

        modelList = new ArrayList<>();
        modelList.add(new Model("Men's Slim Fit Casual Shirt", getString(R.string.men1), R.drawable.men1));
        modelList.add(new Model("Slim Fit Jeans", getString(R.string.women2), R.drawable.women2));


        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter2(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        menActivity = true;

    }
}