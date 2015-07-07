package com.example.joakes.volleyeventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.VolleyError;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {
    private final String REQUEST_TAG = getClass().getName();
    private TextView textView;
    private EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        eventBus = EventBus.getDefault();
        eventBus.register(this);
        new GoogleStringRequest(this, REQUEST_TAG).makeRequest();
    }

    public void onEvent(String response) {
        textView.setText(response);
    }

    public void onEvent(VolleyError error) {
        textView.setText("That didn't work!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        WebRequestQueue.getInstance(this).cancelAll(REQUEST_TAG);
        eventBus.unregister(this);
    }
}
