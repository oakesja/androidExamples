package com.example.joakes.cardsrecyclerviewexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBarActivity;

import com.github.florent37.materialviewpager.HeaderDesign;
import com.github.florent37.materialviewpager.MaterialViewPager;


public class MainActivity extends ActionBarActivity {

    private Game[] games;
    private MaterialViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        viewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new PagerFragment();
                int type = position == 0 ? Game.XBOX360 : Game.XBOX_ONE;
                Bundle bundle = new Bundle();
                bundle.putInt(PagerFragment.FILTER_TYPE, type);
                fragment.setArguments(bundle);
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Xbox 360";
                    case 1:
                        return "Xbox One";
                }
                return "";
            }
        });

        viewPager.setMaterialViewPagerListener(new MaterialViewPager.MaterialViewPagerListener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                String url = "http://images-eds.xboxlive.com//image?url=z951ykn43p4FqWbbFvR2Ec.8vbDhj8G2Xe7JngaTToBrrCmIEEXHC9UNrdJ6P7KIAbCDABRYREOfuoy2FOUr6jBmIGqp2iomsTK.Cz7APn6dX_VO8g7EjO9bVtm1wsWd&format=png";
                return HeaderDesign.fromColorResAndUrl(R.color.green, url);
            }
        });

        viewPager.getViewPager().setOffscreenPageLimit(viewPager.getViewPager().getAdapter().getCount());
        viewPager.getPagerTitleStrip().setViewPager(viewPager.getViewPager());
    }

//    private void createGames() {
//        games = new Game[]{
//                new Game(R.mipmap.fallout, "fallout", Game.XBOX360),
//                new Game(R.mipmap.halo_4, "halo", Game.XBOX360),
//                new Game(R.mipmap.south_park, "south park", Game.XBOX360),
//                new Game(R.mipmap.ac, "assasins's creed", Game.XBOX_ONE),
//                new Game(R.mipmap.plantsvszombies, "plants vs zombines", Game.XBOX_ONE),
//                new Game(R.mipmap.watch_dogs, "watch dogs", Game.XBOX_ONE),
//        };
//    }
}
