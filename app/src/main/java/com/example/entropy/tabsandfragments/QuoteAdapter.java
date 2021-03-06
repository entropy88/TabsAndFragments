package com.example.entropy.tabsandfragments;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteViewHolder>{


        private List<Quote> data;

        public QuoteAdapter(List<Quote> data) {
            this.data = data;
        }

        @Override
        public QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_item_layout,parent,false);
           QuoteViewHolder viewHolder= new QuoteViewHolder(view);
            return viewHolder;
        }



    @Override
        public void onBindViewHolder(final QuoteViewHolder holder, int position) {

            final Quote item=data.get(position);

            holder.mText.setText(item.getText());
            holder.mAuthor.setText(item.getAuthor());
            holder.mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.quotesDb.quotesDao().deleteQuote(item.getId());
                    Toast.makeText(view.getContext(), "Quote deleted", Toast.LENGTH_SHORT).show();

                }
            });


        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


