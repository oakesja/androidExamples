package com.example.joakes.cardsrecyclerviewexample;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by joakes on 4/22/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCardsShowCorrectly(){
        onView(withId(R.id.myRecyclerView)).check(matches(isDisplayed()));
        String[] expectedItems = new String[]{"fallout", "halo", "south park"};
        for (String expectedItem : expectedItems) {
            onView(withText(expectedItem)).check(matches(isDisplayed()));
        }
    }
}
