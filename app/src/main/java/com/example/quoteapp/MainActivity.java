package com.example.quoteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CopyListener{
    RecyclerView recyclerView;
    RequestManager manager;
    QuoteRecylerAdapter adapter;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);

        manager = new RequestManager(this);
        manager .GetAllQuotes(listener);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading....");
        dialog.show();
    }
    private final QuotesresponseListener listener = new QuotesresponseListener() {
        @Override
        public void didFetch(List<Quoteresponse> response, String message) {
            showData(response);
            dialog.dismiss();
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<Quoteresponse> response) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        adapter= new QuoteRecylerAdapter(MainActivity.this,response,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCopyClicked(String text) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data = ClipData.newPlainText("Copied data",text);
        clipboardManager.setPrimaryClip(data);
        Toast.makeText(MainActivity.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
    }
}