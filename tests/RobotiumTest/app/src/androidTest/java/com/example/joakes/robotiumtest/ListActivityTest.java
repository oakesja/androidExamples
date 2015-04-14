package com.example.joakes.robotiumtest;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by joakes on 4/10/15.
 */
public class ListActivityTest extends ActivityInstrumentationTestCase2<ListActivity> {
    private Solo solo;

    public ListActivityTest() {
        super(ListActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        solo.unlockScreen();
        solo.assertCurrentActivity("Should start on List Activity", ListActivity.class);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testListView() {
        String[] expectedItems = new String[]{"test", "test2", "test3"};
        for (String expectedItem : expectedItems) {
            assertTrue(solo.searchText(expectedItem));
        }
    }
}
