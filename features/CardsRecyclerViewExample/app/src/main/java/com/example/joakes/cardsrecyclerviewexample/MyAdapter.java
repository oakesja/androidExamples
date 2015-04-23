package com.example.joakes.cardsrecyclerviewexample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private Game[] mGames;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textView);
            mImageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    public MyAdapter(Context context, Game[] games) {
        mContext = context;
        mGames = games;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(getGame(position).getTitle());
        Drawable drawable = mContext.getResources().getDrawable(getGame(position).getCoverArtId());
        holder.mImageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return mGames.length;
    }

    private Game getGame(int position) {
        return mGames[position];
    }
}