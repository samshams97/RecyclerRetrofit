package com.example.recyclerretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.TestHolder> {
    private ArrayList<ModelClass> moviesList;
    private Context context;

    public MoviesAdapter(ArrayList<ModelClass> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movies_items,parent,false);
        TestHolder holder = new TestHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        ModelClass model = moviesList.get(position);
        holder.title.setText(model.getName());
        holder.description.setText(model.getName());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class TestHolder extends RecyclerView.ViewHolder{
        TextView title,description;

        public TestHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.moviesTitle);
            description = itemView.findViewById(R.id.moviesDescription);
        }
    }
}
