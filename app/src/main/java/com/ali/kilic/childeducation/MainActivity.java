package com.ali.kilic.childeducation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAnimals;
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
    public void init()
    {
        btnAnimals=findViewById(R.id.buttonAnimals);
        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AnimalsActivity.class);
                startActivity(intent);
            }
        });

    }

}