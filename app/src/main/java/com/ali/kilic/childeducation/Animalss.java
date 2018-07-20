package com.ali.kilic.childeducation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Animalss extends AppCompatActivity {
    RecyclerView animalsListView;
    AnimalsAdapter animalsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animalss);
        init();


    }

    private void init() {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("cow");
        animals.add("dog");
        animals.add("donkey");
        animals.add("sheep");
        animals.add("chick");
        animalsListView = findViewById(R.id.animalsListView);
        animalsAdapter = new AnimalsAdapter(getApplicationContext(), animals);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        animalsListView.setLayoutManager(linearLayoutManager);

    }
}