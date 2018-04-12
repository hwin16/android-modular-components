package com.ohmphwa.democardlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Htut Khine Win(htutkhwin@gmail.com) on 4/12/18.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {
    private String[] mDataSource;

    public CardViewAdapter(String[] data){
        mDataSource = data;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        boolean attachToParentImmediately = false;
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, attachToParentImmediately);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mDataSource.length;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private TextView mCardTextView;

        public CardViewHolder(View itemView) {
            super(itemView);

            mCardTextView = (TextView) itemView.findViewById(R.id.tv_card_text);
        }

        public void bind(int position) {
            mCardTextView.setText(mDataSource[position]);
        }
    }
}
