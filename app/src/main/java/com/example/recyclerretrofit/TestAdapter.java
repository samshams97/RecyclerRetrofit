package com.example.recyclerretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {
    private ArrayList<ModelClass> list;
    private Context context;

    public TestAdapter(ArrayList<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_items,parent,false);
        TestHolder testHolder = new TestHolder(v);
        return testHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        ModelClass modelClass = list.get(position);
        holder.desc.setText(modelClass.getDesc());
        holder.title.setText(modelClass.getImage());
        Picasso.get().load(modelClass.getImage()).into(holder.carImg);

    }


    
    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class TestHolder extends  RecyclerView.ViewHolder{
        TextView desc , title;
        ImageView carImg;

        public TestHolder(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.car_description);
            title = itemView.findViewById(R.id.car_title);
            carImg = itemView.findViewById(R.id.car_imaage);
        }
    }
}
