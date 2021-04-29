package com.mazharali.sofittask.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mazharali.sofittask.R;
import com.mazharali.sofittask.constants.Const;
import com.mazharali.sofittask.model.ImageTextModel;

import java.util.List;

public class PaymentHistory extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ImageTextModel> list;
    private Fragment context;

    public PaymentHistory(Fragment context, List<ImageTextModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_history_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        try {
            Glide
                    .with(context)
                    .load(R.drawable.icon_history)
                    .into(myViewHolder.imageView);
            myViewHolder.imageDetail.setText(list.get(position).getImageDetail());
        } catch (Exception ignored) {

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView imageDetail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.payment_history_img_id);
            imageDetail = itemView.findViewById(R.id.payment_history_text_id);


        }
    }
}
