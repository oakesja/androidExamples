package com.example.joakes.robotiumtest;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        solo.unlockScreen();
        solo.assertCurrentActivity("Should start on Main Activity", MainActivity.class);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testClickingOnButtonOpensNewActivity() {
        boolean button = solo.searchButton(getString(R.string.button_text));
        assertTrue(button);
        solo.clickOnButton(getActivity().getString(R.string.button_text));
        solo.assertCurrentActivity("Clicking button takes you to the list activity", ListActivity.class);
    }

    public void testClickingOnMenuItemOpensDialog() {
        solo.clickOnMenuItem(getString(R.string.menu_item));
        boolean has_dialog = solo.waitForDialogToOpen();
        assertTrue(has_dialog);
        boolean has_dialog_title = solo.searchText((getString(R.string.dialog_title)));
        assertTrue(has_dialog_title);
    }

    private String getString(int id) {
        return getActivity().getString(id);
    }
}