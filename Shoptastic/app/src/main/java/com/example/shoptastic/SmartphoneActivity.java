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
        modelList.add(new Model("OPPO A74 5G", getString(R.string.mob3), R.drawable.mobile3));
        modelList.add(new Model("Vivo Y73", getString(R.string.mob4), R.drawable.mobile4));
        modelList.add(new Model("Realme Narzo 50A", getString(R.string.mob5), R.drawable.mobile5));
        modelList.add(new Model("Poco X3 Pro", getString(R.string.mob6), R.drawable.mobile6));


        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter3(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}