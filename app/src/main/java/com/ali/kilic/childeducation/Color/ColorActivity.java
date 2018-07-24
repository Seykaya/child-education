package com.ali.kilic.childeducation.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.ali.kilic.childeducation.R;
import java.util.ArrayList;
import java.util.List;
public class ColorActivity extends AppCompatActivity{
    RecyclerView colorListView;
    List<Integer> colorIDList=new ArrayList<>();
    ColorAdapter colorAdapter;
    IColorAadapterClicks colorAadapterClicks=new IColorAadapterClicks() {
        @Override
        public void colorItemClick(String colorName) {

        }
    };
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        colorListView = findViewById(R.id.ColorListView);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        colorListView.setLayoutManager(gridLayoutManager);
        colorIDList.add(R.drawable.exo_notification_pause);
        colorIDList.add(R.drawable.exo_notification_play);

        colorAdapter=new ColorAdapter(colorIDList,getApplicationContext());
        colorListView.setAdapter(colorAdapter);

    }


}
