package com.ali.kilic.childeducation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.MyViewHolder> {

    Context context;
    List<String> animals;
    IAnimasAdapterClicks animasAdapterClicks;

    public AnimalsAdapter(Context context, List<String> animals) {
        this.context = context;
        this.animals = animals;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_animals_item, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.animalsName.setText(animals.get(position).toString());
        holder.animalsName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animasAdapterClicks!=null){
                    animasAdapterClicks.animalItemCLick(holder.animalsName.getText().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView animalsName;

        public MyViewHolder(View itemView) {
            super(itemView);
            animalsName = itemView.findViewById(R.id.animalsName);

        }
    }
}
