package com.example.quoteapp;

import java.util.List;

public interface QuotesresponseListener {
    void didFetch(List<Quoteresponse> response, String message);
    void didError(String message);
}
