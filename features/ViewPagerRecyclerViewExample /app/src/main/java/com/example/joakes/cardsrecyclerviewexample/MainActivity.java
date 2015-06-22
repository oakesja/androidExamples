package com.example.joakes.cardsrecyclerviewexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import de.greenrobot.event.EventBus;


public class MainActivity extends ActionBarActivity {

    private Game[] games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGames();

        FragmentStatePagerAdapter viewPagerAdapter = new PagerAdapter(this, getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(viewPagerAdapter);
        EventBus eventBus = EventBus.getDefault();
        eventBus.post(games);
    }

    private void createGames() {
        games = new Game[]{
                new Game(R.mipmap.fallout, "fallout", Game.XBOX360),
                new Game(R.mipmap.halo_4, "halo", Game.XBOX360),
                new Game(R.mipmap.south_park, "south park", Game.XBOX360),
                new Game(R.mipmap.ac, "assasins's creed", Game.XBOX_ONE),
                new Game(R.mipmap.plantsvszombies, "plants vs zombines", Game.XBOX_ONE),
                new Game(R.mipmap.watch_dogs, "watch dogs", Game.XBOX_ONE),
        };
    }
}
