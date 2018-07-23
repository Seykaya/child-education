package com.ali.kilic.childeducation.Professions;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ali.kilic.childeducation.AnimalsAdapter;
import com.ali.kilic.childeducation.IAnimasAdapterClicks;
import com.ali.kilic.childeducation.R;

import java.util.ArrayList;
import java.util.List;

public class ProsfessionActivity extends AppCompatActivity {

    RecyclerView professionListView;
    List<Integer> professionIDList=new ArrayList<>();
    ProfessionAdapter professionAdapter;
    IProfessionAdapterClicks professionAdapterClicks = new IProfessionAdapterClicks() {

        @Override
        public void professionItemClick(String professionName) {

        }
    };

    /**
     * activity oluştuğunda ilk bu kısma girer
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession);
        professionListView = findViewById(R.id.professionListView);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        professionListView.setLayoutManager(gridLayoutManager);
        professionIDList.add(R.drawable.miner);
        professionIDList.add(R.drawable.chef);
        professionIDList.add(R.drawable.civil_engineer);
        professionIDList.add(R.drawable.police);
        professionIDList.add(R.drawable.nurse);
        professionAdapter=new ProfessionAdapter(professionIDList,getApplicationContext());
        professionListView.setAdapter(professionAdapter);

    }
}
