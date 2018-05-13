package com.example.entropy.tabsandfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FragmentTwo extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,container,false);

        recyclerView=(RecyclerView) view.findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        List<Quote> quotesList = MainActivity.quotesDb.quotesDao().getQuotes();
        QuoteAdapter adapter= new QuoteAdapter(quotesList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
