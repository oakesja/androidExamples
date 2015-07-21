package com.example.joakes.volleyeventbusdemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import de.greenrobot.event.EventBus;

/**
 * Created by joakes on 6/30/15.
 */
public class GoogleStringRequest {
    private final EventBus eventBus;
    private Context context;

    public GoogleStringRequest(Context context) {
        this.context = context;
        eventBus = EventBus.getDefault();
    }

    public void makeRequest(String tag) {
        String url = "http://www.google.com";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        eventBus.post(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        eventBus.post(error);
                    }
                });
        WebRequestQueue.getInstance(context).addToQueue(stringRequest, tag);
    }
}
