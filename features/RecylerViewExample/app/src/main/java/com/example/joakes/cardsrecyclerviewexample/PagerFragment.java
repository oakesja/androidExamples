package com.example.joakes.cardsrecyclerviewexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by joakes on 6/22/15.
 */
public class PagerFragment extends Fragment {
    public static final String FILTER_TYPE = "FILTER_TYPE";
    private RecylerAdapter recylerAdapter;
    private RecyclerViewMaterialAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        return inflater.inflate(R.layout.pager_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.games_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recylerAdapter = new RecylerAdapter(getActivity());
        adapter = new RecyclerViewMaterialAdapter(recylerAdapter);
        recyclerView.setAdapter(adapter);
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), recyclerView, null);
    }

    public void onEvent(Game[] games) {
        Bundle args = getArguments();
        int type = args.getInt(FILTER_TYPE);
        ArrayList<Game> filteredGames = new ArrayList<>();
        for (int i = 0; i < games.length; i++) {
            if(games[i].getType() == type){
                filteredGames.add(games[i]);
            }
        }
        games = filteredGames.toArray(new Game[filteredGames.size()]);
        Log.i("test", "onEvent start set games");
        recylerAdapter = new RecylerAdapter(getActivity(), games);
        adapter = new RecyclerViewMaterialAdapter(recylerAdapter);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(adapter);
            }
        });
        Log.i("test", "onEvent finish set games");
    }
}
