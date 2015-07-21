package com.example.joakes.volleyeventbusdemo;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.joakes.volleyeventbusdemo.dagger.BaseApplication;
import com.example.joakes.volleyeventbusdemo.dagger.IComponent;
import com.example.joakes.volleyeventbusdemo.helpers.EventBusHelper;
import com.example.joakes.volleyeventbusdemo.helpers.MockRequestModule;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Singleton;

import dagger.Component;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

/**
 * Created by joakes on 7/7/15.
 */
public class MainActivityUnitTest extends ActivityTestRule<MainActivity> {
    EventBusHelper eventBusHelper;

    public MainActivityUnitTest() {
        super(MainActivity.class);
    }

    @Singleton
    @Component(modules = {MockRequestModule.class})
    public interface TestComponent extends IComponent {
    }

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        BaseApplication app = (BaseApplication) instrumentation.getTargetContext().getApplicationContext();
        TestComponent component = DaggerMainActivityUnitTest_TestComponent.builder()
                .mockRequestModule(new MockRequestModule())
                .build();
        app.setComponent(component);
        eventBusHelper = new EventBusHelper(this);
        launchActivity(new Intent());
    }

    @Test
    public void handleStringResponse() {
        String response = "test";
        eventBusHelper.post(response);
        onView(withId(R.id.text)).check(matches(withText(response)));
    }

    @Test
    public void handleVolleyError() {
        String expected = "That didn't work!";
        eventBusHelper.post(new VolleyError());
        onView(withId(R.id.text)).check(matches(withText(expected)));
    }
}
