package com.example.quoteapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuoteRecylerAdapter extends RecyclerView.Adapter<QuoteViewHolder>{
    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class QuoteViewHolder extends RecyclerView.ViewHolder {

    TextView textviewquote,textviewquoteauthor;
    Button button_copy;

    public QuoteViewHolder(@NonNull View itemView) {
        super(itemView);
        textviewquote=itemView.findViewById(R.id.textviewquote);
        textviewquoteauthor=itemView.findViewById(R.id.textviewquoteauthor);
        button_copy=itemView.findViewById(R.id.button_copy);
    }
}
