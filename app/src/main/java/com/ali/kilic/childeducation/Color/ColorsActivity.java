package com.ali.kilic.childeducation.Color;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ali.kilic.childeducation.R;

import java.util.HashMap;
import java.util.Locale;

import jp.wasabeef.recyclerview.animators.FadeInAnimator;

public class ColorsActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    RecyclerView colorListView;
    HashMap<String, Integer> colorIDList = new HashMap<>();
    ColorAdapter colorAdapter;
    TextToSpeech textToSpeech;

    IColorAadapterClicks colorAdapterClicks = new IColorAadapterClicks() {
        @Override
        public void colorItemClick(String colorName) {
            textToSpeech.setLanguage(new Locale("tr-TR"));
            textToSpeech.speak(colorName, TextToSpeech.QUEUE_ADD, null);
        }
    };

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        setAdapters();
        textToSpeech = new TextToSpeech(getApplicationContext(), this);
        textToSpeech.setSpeechRate(0.6f);
        colorIDList.put("beyaz", R.color.white);
        colorIDList.put("sarı", R.color.yellow);
        colorIDList.put("pembe", R.color.purple);
        colorIDList.put("kırmızı", R.color.red);
        colorIDList.put("gri", R.color.gray);
        colorIDList.put("turkuaz", R.color.aqua);
        colorIDList.put("yeşil", R.color.green);
        colorIDList.put("mavi", R.color.blue);
        colorIDList.put("siyah", R.color.black);

    }

    private void setAdapters() {
        colorListView = findViewById(R.id.ColorListView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        colorListView.setLayoutManager(gridLayoutManager);
        colorAdapter = new ColorAdapter(colorIDList, getApplicationContext());
        colorAdapter.colorAdapterClicks = colorAdapterClicks;
        colorListView.setAdapter(colorAdapter);
        colorListView.setItemAnimator(new FadeInAnimator());
        colorListView.getItemAnimator().setAddDuration(1000);
        colorListView.getItemAnimator().setRemoveDuration(1000);
        colorListView.getItemAnimator().setMoveDuration(1000);
        colorListView.getItemAnimator().setChangeDuration(1000);
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
