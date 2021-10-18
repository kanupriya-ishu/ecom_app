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
    boolean womenActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_women_fashion); 

        modelList = new ArrayList<>(); 
        modelList.add(new Model("Anarkali Dress", getString(R.string.women1), R.drawable.women1));
        modelList.add(new Model("Slim Fit Jeans", getString(R.string.women2), R.drawable.women2));


        // recyclerview
        recyclerView = findViewById(R.id.recyclerView); 
        recyclerView.setLayoutManager(new LinearLayoutManager(null)); 
        // adapter
        mAdapter = new OrderAdapter(this, modelList); 
        recyclerView.setAdapter(mAdapter); 
    }

    @Override
    protected void onStart(){
        super.onStart();
        womenActivity = true;

    }
}