package com.example.joakes.cardsrecyclerviewexample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder> {
    private Context context;
    private Game[] games;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textView);
            mImageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    public RecylerAdapter(Context context) {
        this.context = context;
        games = new Game[0];
    }

    public RecylerAdapter(Context context, Game[] games) {
        this.context = context;
        this.games = games;
    }

    @Override
    public RecylerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(getGame(position).getTitle());
        Drawable drawable = context.getResources().getDrawable(getGame(position).getCoverArtId());
        holder.mImageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return games.length;
    }

    public void setGames(Game[] games){
        Log.i("test", "setGames");
        this.games = games;
        this.notifyDataSetChanged();
        Log.i("test", "setGames done");
    }

    private Game getGame(int position) {
        return games[position];
    }
}