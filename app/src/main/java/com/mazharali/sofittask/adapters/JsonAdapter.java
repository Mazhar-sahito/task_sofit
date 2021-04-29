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
import com.mazharali.sofittask.model.ImageTextModel;
import com.mazharali.sofittask.retrofit.JsonPojo;

import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<JsonPojo> list;
    private Fragment context;

    public JsonAdapter(List<JsonPojo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.json_data_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.userId.setText("" + list.get(position).getUserId());
        myViewHolder.iD.setText( "" +list.get(position).getId());
        myViewHolder.title.setText(list.get(position).getTitle());
        myViewHolder.desc.setText(list.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userId, iD, title, desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.user_id_text);
            iD = itemView.findViewById(R.id.id_text);
            title = itemView.findViewById(R.id.title_text);
            desc = itemView.findViewById(R.id.desc_text);
        }
    }
}
