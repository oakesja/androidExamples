package com.example.joakes.volleyeventbusdemo;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by joakes on 6/30/15.
 */
public class WebRequestQueue {
    private static WebRequestQueue webRequestQueue;
    private RequestQueue volleyRequestQueue;

    private WebRequestQueue(Context context) {
        volleyRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static WebRequestQueue getInstance(Context context) {
        if (webRequestQueue == null) {
            synchronized (WebRequestQueue.class) {
                if (webRequestQueue == null) {
                    webRequestQueue = new WebRequestQueue(context);
                }
            }
        }
        return webRequestQueue;
    }

    public static void setInstance(WebRequestQueue requestQueue) {
        webRequestQueue = requestQueue;
    }

    public void addToQueue(Request request, String tag) {
        request.setTag(tag);
        volleyRequestQueue.add(request);
    }

    public void cancelAll(String tag) {
        volleyRequestQueue.cancelAll(tag);
    }
}
