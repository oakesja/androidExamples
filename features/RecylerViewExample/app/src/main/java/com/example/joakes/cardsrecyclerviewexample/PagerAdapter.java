package com.example.joakes.cardsrecyclerviewexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import de.greenrobot.event.EventBus;

/**
 * Created by joakes on 6/22/15.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    private final String[] tabs;
    private Game[] games;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        tabs = context.getResources().getStringArray(R.array.pager_tab_titles);
        EventBus eventbus = EventBus.getDefault();
        eventbus.register(this);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        int filter = i == 0 ? Game.XBOX360 : Game.XBOX_ONE;
        args.putInt(PagerFragment.FILTER_TYPE, filter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    public void onEvent(Game[] games) {
        this.games = games;
    };
}
