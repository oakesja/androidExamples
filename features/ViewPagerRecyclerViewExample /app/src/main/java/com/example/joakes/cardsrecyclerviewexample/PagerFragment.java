package com.example.joakes.cardsrecyclerviewexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

/**
 * Created by joakes on 6/22/15.
 */
public class PagerFragment extends Fragment {
    public static final String FILTER_TYPE = "FILTER_TYPE";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.games_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RecyclerViewMaterialAdapter(new RecylerAdapter(getActivity(), createGames()));
        recyclerView.setAdapter(adapter);
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), recyclerView, null);
    }

    private Game[] createGames() {
        Bundle args = getArguments();
        int type = args.getInt(FILTER_TYPE);
        if(type == Game.XBOX_ONE){
            return new Game[]{
                    new Game(R.mipmap.ac, "assasins's creed", Game.XBOX_ONE),
                    new Game(R.mipmap.plantsvszombies, "plants vs zombines", Game.XBOX_ONE),
                    new Game(R.mipmap.watch_dogs, "watch dogs", Game.XBOX_ONE),
            };
        } else {
            return new Game[]{
                    new Game(R.mipmap.fallout, "fallout", Game.XBOX360),
                    new Game(R.mipmap.halo_4, "halo", Game.XBOX360),
                    new Game(R.mipmap.south_park, "south park", Game.XBOX360),
            };
        }
    }
}
