package com.example.joakes.espressotest;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by joakes on 4/15/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickingOnButtonOpensNewActivity() {
        onView(withId(R.id.button)).perform(click());
        onView(withText(getString(R.string.title_activity_list))).check(matches(isDisplayed()));
    }

    public void testClickingOnMenuItemOpensDialog() {
        onView(withId(R.id.menu_item)).perform(click());
        onView(withText(getString(R.string.dialog_title))).check(matches(isDisplayed()));
    }

    private String getString(int id) {
        return getActivity().getString(id);
    }

}
