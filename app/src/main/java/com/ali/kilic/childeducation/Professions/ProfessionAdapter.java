package com.ali.kilic.childeducation.Professions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ali.kilic.childeducation.R;

import java.util.ArrayList;
import java.util.List;

public class ProfessionAdapter
        extends RecyclerView.Adapter<ProfessionAdapter.MyViewHolder> {

    List<Integer> professionIDList;
    Context context;
    IProfessionAdapterClicks professionAdapterClicks;

    public ProfessionAdapter(List<Integer> professionIDList, Context context) {
        this.professionIDList = professionIDList;
        this.context = context;
    }

    //ekranda görülen nesneler için inflation(xml den javaya dönüşüm) işlemi yapıyor
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_profession_item,
                        null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.professionImage.setImageDrawable(
                context.getResources().getDrawable(
                        professionIDList.get(position)));
        holder.professionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (professionAdapterClicks != null) {
                    professionAdapterClicks.professionItemClick(
                            context.getResources().getResourceEntryName(
                                    professionIDList.get(position)));
                }
                view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.clicked_anim));
            }

        });
    }

    @Override
    public int getItemCount() {
        return professionIDList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView professionImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            professionImage = itemView.findViewById(R.id.imageProfession);
        }
    }
}
