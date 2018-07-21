package com.ali.kilic.childeducation.Numbers;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ali.kilic.childeducation.R;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class NumbersActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {


    TextToSpeech tts;
    RecyclerView numberListView;
    NumbersAdapter numbersAdapter;
    INumbersAdapterClicks numbersAdapterClicks = new INumbersAdapterClicks() {
        @Override
        public void animalItemCLick(String number) {
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
        List<String> animals = Arrays.asList(getResources().getStringArray(R.array.myNumber));
        numberListView = findViewById(R.id.numberListView);
        numbersAdapter = new NumbersAdapter(getApplicationContext(), animals);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        numberListView.setLayoutManager(linearLayoutManager);
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
