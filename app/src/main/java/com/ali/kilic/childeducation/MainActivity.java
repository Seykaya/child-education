package com.ali.kilic.childeducation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView animalsListView;
    AnimalsAdapter animalsAdapter;
    IAnimasAdapterClicks animasAdapterClicks = new IAnimasAdapterClicks() {
        @Override
        public void animalItemCLick(String animalName) {
            MusicHelper.getInstance().play("file:///android_asset/" + animalName + ".mp3",
                    getApplicationContext());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MusicHelper.getInstance().play("file:///android_asset/relaxing.mp3", getApplicationContext());
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
        List<String> animals =  Arrays.asList(getResources().getStringArray(R.array.myAnimals));
        animalsListView = findViewById(R.id.animalsListView);
        animalsAdapter = new AnimalsAdapter(getApplicationContext(), animals);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        animalsListView.setLayoutManager(linearLayoutManager);
        animalsAdapter.animasAdapterClicks = animasAdapterClicks;
        animalsListView.setAdapter(animalsAdapter);

    }
}