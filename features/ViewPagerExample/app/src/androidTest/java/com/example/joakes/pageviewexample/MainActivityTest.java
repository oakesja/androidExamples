package com.example.joakes.pageviewexample;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testAllPagesPresent() {
        for (int i = 0; i < 100; i++) {
            onView(withId(R.id.pager_title_strip))
                    .check(matches(hasDescendant(withText("Object " + i))));
            onView(withId(R.id.pager))
                    .check(matches(hasDescendant(withText("" + i))));
            onView(withId(R.id.pager))
                    .perform(swipeLeft());
        }
    }
}
