package com.ali.kilic.childeducation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ali.kilic.childeducation.Animals.AnimalsActivity;
import com.ali.kilic.childeducation.Animals.IAnimasAdapterClicks;
import com.ali.kilic.childeducation.Color.ColorsActivity;
import com.ali.kilic.childeducation.Numbers.NumbersActivity;
import com.ali.kilic.childeducation.Player.MyPlayer;
import com.ali.kilic.childeducation.Professions.ProsfessionActivity;

public class MainActivity extends AppCompatActivity {
    Button btnAnimals;
    Button btnNumbers;
    Button btnProfession;
    Button btnColors;
    RecyclerView animalsListView;
    IAnimasAdapterClicks animasAdapterClicks = new IAnimasAdapterClicks() {
        @Override
        public void animalItemCLick(String animalName) {
            MyPlayer.getInstance().play("file:///android_asset/" + animalName + ".mp3",
                    getApplicationContext());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyPlayer.getInstance().play("file:///android_asset/relaxing.mp3", getApplicationContext());
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {

        btnAnimals = findViewById(R.id.buttonAnimals);
        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAnimals = new Intent(getApplicationContext(), AnimalsActivity.class);
                startActivity(intentAnimals);
            }
        });
        btnNumbers = findViewById(R.id.buttonNumbers);
        btnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNumbers = new Intent(getApplicationContext(), NumbersActivity.class);
                startActivity(intentNumbers);
            }
        });
        btnProfession = findViewById(R.id.buttonProfesions);
        btnProfession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfession = new Intent(getApplicationContext(), ProsfessionActivity.class);
                startActivity(intentProfession);
            }
        });

        btnColors = findViewById(R.id.buttonColors);
        btnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ColorsActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyPlayer.getInstance().stop(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyPlayer.getInstance().pause();

    }
}