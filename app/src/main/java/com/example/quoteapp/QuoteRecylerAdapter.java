package com.example.quoteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuoteRecylerAdapter extends RecyclerView.Adapter<QuoteViewHolder>{

    Context context;
    List<Quoteresponse> list;
    CopyListener listener;

    public QuoteRecylerAdapter(Context context, List<Quoteresponse> list, CopyListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new QuoteViewHolder(LayoutInflater.from(context).inflate(R.layout.quote_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        holder.textviewquote.setText(list.get(position).getText());
        holder.textviewquoteauthor.setText(list.get(position).getAuthor());
        holder.button_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCopyClicked(list.get(holder.getAdapterPosition()).getText());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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
