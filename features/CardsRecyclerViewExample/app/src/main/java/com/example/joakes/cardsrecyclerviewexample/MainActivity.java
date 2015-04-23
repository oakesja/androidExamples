package com.example.joakes.cardsrecyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Game[] games = new Game[]{
                new Game(R.mipmap.fallout, "fallout"),
                new Game(R.mipmap.halo_4, "halo"),
                new Game(R.mipmap.south_park, "south park")
        };
        RecyclerView.Adapter adapter = new MyAdapter(this, games);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}
