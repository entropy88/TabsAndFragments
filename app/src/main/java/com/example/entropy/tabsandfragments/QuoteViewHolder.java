package com.example.entropy.tabsandfragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuoteViewHolder extends RecyclerView.ViewHolder {

        TextView mText;
        TextView mAuthor;


        public QuoteViewHolder(View itemView) {
            super(itemView);

            mText= (TextView)itemView.findViewById(R.id.itemTexts);
            mAuthor= (TextView) itemView.findViewById(R.id.itemAuthor);

        }
    }

