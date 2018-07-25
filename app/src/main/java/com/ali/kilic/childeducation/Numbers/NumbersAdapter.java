package com.ali.kilic.childeducation.Numbers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.kilic.childeducation.R;

import java.util.List;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.MyViewHolder> {

    Context context;
    List<Integer> numbersIDList;
    INumbersAdapterClicks numbersAdapterClicks;


    public NumbersAdapter(Context context, List<Integer> numbers) {
        this.context = context;
        this.numbersIDList = numbers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_numbers_item, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.numberImage.setImageDrawable(context.getResources().getDrawable(numbersIDList.get(position)));
        holder.numberImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numbersAdapterClicks != null) {
                    numbersAdapterClicks.numberlItemCLick(context.getResources().getResourceEntryName(
                            numbersIDList.get(position)
                    ));
                }
                view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.clicked_anim));
            }

        });
    }

    @Override
    public int getItemCount() {
        return numbersIDList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView numberImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            numberImage = itemView.findViewById(R.id.number);

        }
    }
}
