package com.example.joakes.cardsrecyclerviewexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by joakes on 6/22/15.
 */
public class PagerFragment extends Fragment {
    public static final String FILTER_TYPE = "FILTER_TYPE";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pager_fragment, container, false);
        Bundle args = getArguments();
        int type = args.getInt(FILTER_TYPE);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.games_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RecylerAdapter(getActivity(), createGames());
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private Game[] createGames() {
        return new Game[]{
                new Game(R.mipmap.fallout, "fallout", Game.XBOX360),
                new Game(R.mipmap.halo_4, "halo", Game.XBOX360),
                new Game(R.mipmap.south_park, "south park", Game.XBOX360),
                new Game(R.mipmap.ac, "assasins's creed", Game.XBOX_ONE),
                new Game(R.mipmap.plantsvszombies, "plants vs zombines", Game.XBOX_ONE),
                new Game(R.mipmap.watch_dogs, "watch dogs", Game.XBOX_ONE),
        };
    }
}
