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
    private String tag;

    public GoogleStringRequest(Context context, String tag) {
        this.context = context;
        this.tag = tag;
        eventBus = EventBus.getDefault();
    }

    public void makeRequest() {
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
