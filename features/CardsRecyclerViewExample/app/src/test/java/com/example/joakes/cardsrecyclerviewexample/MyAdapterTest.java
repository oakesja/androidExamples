package com.example.joakes.cardsrecyclerviewexample;

import android.widget.LinearLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowDrawable;

import static org.junit.Assert.assertEquals;
import static org.fest.assertions.api.ANDROID.assertThat;

/**
 * Created by joakes on 4/22/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class MyAdapterTest {
    private MyAdapter mAdapter;
    private Game[] mGames;

    @Before
    public void setUp() {
        mGames = new Game[]{
                new Game(R.mipmap.fallout, "fallout"),
                new Game(R.mipmap.halo_4, "halo"),
                new Game(R.mipmap.south_park, "south park")
        };

        mAdapter = new MyAdapter(RuntimeEnvironment.application, mGames);
    }

    @Test
    public void testAdapterSize() {
        assertEquals(3, mAdapter.getItemCount());
    }

    @Test
    public void testCorrectItemsDisplayed() {
        LinearLayout group = new LinearLayout(RuntimeEnvironment.application);
        MyAdapter.ViewHolder holder = mAdapter.onCreateViewHolder(group, 0);

        for (int i = 0; i < mGames.length; i++) {
            mAdapter.onBindViewHolder(holder, i);
            assertThat(holder.mTextView).containsText(mGames[i].getTitle());
            ShadowDrawable shadowDrawable = Shadows.shadowOf(holder.mImageView.getDrawable());
            assertEquals(mGames[i].getCoverArtId(), shadowDrawable.getCreatedFromResId());
        }
    }
}
