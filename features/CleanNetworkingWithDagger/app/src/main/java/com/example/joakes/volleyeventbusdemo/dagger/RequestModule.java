package com.example.joakes.volleyeventbusdemo.dagger;

import android.content.Context;

import com.example.joakes.volleyeventbusdemo.GoogleStringRequest;

import dagger.Module;
import dagger.Provides;

@Module
public class RequestModule {
    private Context context;

    RequestModule(Context context) {
        this.context = context;
    }

    @Provides
    GoogleStringRequest provideGoogleStringRequest() {
        return new GoogleStringRequest(context);
    }
}
