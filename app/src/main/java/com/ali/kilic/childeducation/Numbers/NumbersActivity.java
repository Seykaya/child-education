package com.ali.kilic.childeducation.Numbers;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ali.kilic.childeducation.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class NumbersActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {


    TextToSpeech tts;
    RecyclerView numberListView;
    NumbersAdapter numbersAdapter;
    INumbersAdapterClicks numbersAdapterClicks = new INumbersAdapterClicks() {

        @Override
        public void numberlItemCLick(String number) {
            tts.setLanguage(new Locale("tr-TR"));
            tts.speak(number, TextToSpeech.QUEUE_ADD,
                    null);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        init();
        tts = new TextToSpeech(getApplicationContext(), this);
        tts.setSpeechRate(0.6f);


    }

    private void init() {
        List<Integer> numbers =new ArrayList<>();
        numbers.add(R.drawable.one);
        numbers.add(R.drawable.two);
        numbers.add(R.drawable.three);
        numbers.add(R.drawable.four);
        numbers.add(R.drawable.five);
        numbers.add(R.drawable.six);
        numbers.add(R.drawable.seven);
        numbers.add(R.drawable.eight);
        numbers.add(R.drawable.nine);
        numberListView = findViewById(R.id.numberListView);
        numbersAdapter = new NumbersAdapter(getApplicationContext(),numbers);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        numberListView.setLayoutManager(gridLayoutManager);
        numbersAdapter.numbersAdapterClicks = numbersAdapterClicks;
        numberListView.setAdapter(numbersAdapter);




    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {

        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.ttsFailed),
                    Toast.LENGTH_LONG).show();
        }
    }
}
