package com.ali.kilic.childeducation.Color;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ali.kilic.childeducation.R;

import java.util.HashMap;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.MyViewHolder> {


    HashMap<String, Integer> colorIDList;
    Context context;
    IColorAadapterClicks colorAdapterClicks;

    public ColorAdapter(HashMap<String, Integer> colorIDList, Context context) {
        this.colorIDList = colorIDList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_color_item,
                        null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Object[] keys = colorIDList.keySet().toArray();

        holder.colorImage.setBackgroundColor(
                context.getResources().getColor(colorIDList.get(keys[position])));

        holder.colorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colorAdapterClicks != null) {
                    colorAdapterClicks.colorItemClick(keys[position].toString());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return colorIDList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView colorImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            colorImage = itemView.findViewById(R.id.imagecolor);
        }


    }
}