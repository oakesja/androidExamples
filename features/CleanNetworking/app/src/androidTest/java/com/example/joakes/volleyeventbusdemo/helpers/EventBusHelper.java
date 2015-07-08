package com.example.joakes.volleyeventbusdemo.helpers;

import android.support.test.rule.ActivityTestRule;

import de.greenrobot.event.EventBus;

/**
 * Created by joakes on 7/7/15.
 */
public class EventBusHelper {
    public ActivityTestRule rule;

    public EventBusHelper(ActivityTestRule rule) {
        this.rule = rule;
    }

    public void post(final Object o) {
        try {
            rule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    EventBus.getDefault().post(o);
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
