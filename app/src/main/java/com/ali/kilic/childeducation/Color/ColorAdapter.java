package com.ali.kilic.childeducation.Color;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ali.kilic.childeducation.R;
import com.ali.kilic.childeducation.Utils.CircleTransform;
import com.squareup.picasso.Picasso;

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

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Object[] keys = colorIDList.keySet().toArray();
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(context.getResources().getColor(colorIDList.get(keys[position])));
        Picasso.get().load(context.getResources().getColor(colorIDList.get(keys[position])))
                .placeholder(drawable)
                .transform(new CircleTransform()).into(holder.colorImage);
        holder.colorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colorAdapterClicks != null) {
                    colorAdapterClicks.colorItemClick(keys[position].toString());
                }
                v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.clicked_anim));
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