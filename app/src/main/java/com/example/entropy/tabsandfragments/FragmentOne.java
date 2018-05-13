package com.example.entropy.tabsandfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FragmentOne extends Fragment {


   public static TextView tvAuthor;
    public static TextView tvText;
    ImageButton btnAdd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view= inflater.inflate(R.layout.fragment_fragment_one, container,false);

        tvAuthor= (TextView) view.findViewById(R.id.tv_author);
        tvText= (TextView) view.findViewById(R.id.tv_text);
        btnAdd=(ImageButton) view.findViewById(R.id.btn_add_quote);

        QuotationAsyncTask newQuote= new QuotationAsyncTask();
        newQuote.execute();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Quote newQuote= new Quote();
               newQuote.setId(0);
               newQuote.setAuthor(QuotationAsyncTask.author);
               newQuote.setText(QuotationAsyncTask.text);
               MainActivity.quotesDb.quotesDao().addQuote(newQuote);
               Toast.makeText(view.getContext(), "quote added", Toast.LENGTH_LONG).show();
               btnAdd.setImageResource(R.drawable.ic_favorite_black_24px);
            }
        });

     return view;
    }


}
