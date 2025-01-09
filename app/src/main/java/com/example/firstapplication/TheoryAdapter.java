package com.example.firstapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TheoryAdapter extends RecyclerView.Adapter<TheoryAdapter.ViewHolder> {

    private final String[] titles;
    private final String[] descriptions;
    private final Context context;

    public TheoryAdapter(String[] titles, String[] descriptions, Context context) {
        this.titles = titles;
        this.descriptions = descriptions;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles[position]);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TheoryDetailActivity.class);
            intent.putExtra("title", titles[position]);
            intent.putExtra("description", descriptions[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.my_recycler);
        }
    }
}