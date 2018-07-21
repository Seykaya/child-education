package com.ali.kilic.childeducation.Numbers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ali.kilic.childeducation.R;

import java.util.List;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.MyViewHolder> {

    Context context;
    List<String> numbers;
    INumbersAdapterClicks numbersAdapterClicks;

    public NumbersAdapter(Context context, List<String> numbers) {
        this.context = context;
        this.numbers = numbers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_numbers_item, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.number.setText(numbers.get(position).toString());
        holder.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numbersAdapterClicks != null) {
                    numbersAdapterClicks.animalItemCLick(holder.number.getText().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView number;

        public MyViewHolder(View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);

        }
    }
}
