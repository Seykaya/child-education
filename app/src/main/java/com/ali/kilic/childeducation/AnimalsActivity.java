package com.ali.kilic.childeducation;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class AnimalsActivity extends AppCompatActivity {


    RecyclerView animalsListView;
    AnimalsAdapter animalsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_animals);
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
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        animalsListView.setLayoutManager(linearLayoutManager);

    }
}
