package com.example.joakes.espressotest;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by joakes on 4/15/15.
 */
public class ListActivityTest extends ActivityInstrumentationTestCase2<ListActivity> {

    public ListActivityTest() {
        super(ListActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testListView() {
        String[] expectedItems = new String[]{"test", "test2", "test3"};
        for (String expectedItem : expectedItems) {
            onView(withText(expectedItem)).check(matches(isDisplayed()));
        }
    }
}
