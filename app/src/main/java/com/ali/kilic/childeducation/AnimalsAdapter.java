package com.ali.kilic.childeducation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.MyViewHolder> {

    Context context;
    List<Integer> animalsIDList;
    IAnimasAdapterClicks animasAdapterClicks;

    public AnimalsAdapter(Context context, List<Integer> animals) {
        this.context = context;
        this.animalsIDList = animals;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_animals_item, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.animalsImage.setImageDrawable(context.getResources().getDrawable(animalsIDList.get(position)));
        holder.animalsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animasAdapterClicks != null) {
                    animasAdapterClicks.animalItemCLick(context.getResources().getResourceEntryName(
                            animalsIDList.get(position)
                    ));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return animalsIDList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView animalsImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            animalsImage = itemView.findViewById(R.id.imageAnimals);

        }
    }
}
