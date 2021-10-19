package com.example.shoptastic; 

import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle; 
import android.support.v7.widget.LinearLayoutManager; 
import android.support.v7.widget.RecyclerView; 

import java.util.ArrayList; 
import java.util.List; 

public class WomenFashionActivity extends AppCompatActivity {

    List<Model> modelList; 
    RecyclerView recyclerView; 
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_women_fashion); 

        modelList = new ArrayList<>(); 
        modelList.add(new Model("Anarkali Dress", getString(R.string.women1), R.drawable.women1));
        modelList.add(new Model("Slim Fit Jeans", getString(R.string.women2), R.drawable.women2));
        modelList.add(new Model("Waterfall Shrugs", getString(R.string.women3), R.drawable.women3));
        modelList.add(new Model("Formal Blazer", getString(R.string.women4), R.drawable.women4));
        modelList.add(new Model("Sweatshirt", getString(R.string.women5), R.drawable.women5));
        modelList.add(new Model("Midi Skirt", getString(R.string.women6), R.drawable.women6));
        modelList.add(new Model("Printed Top", getString(R.string.women7), R.drawable.women7));



        // recyclerview
        recyclerView = findViewById(R.id.recyclerView); 
        recyclerView.setLayoutManager(new LinearLayoutManager(null)); 
        // adapter
        mAdapter = new OrderAdapter(this, modelList); 
        recyclerView.setAdapter(mAdapter); 
    }
}