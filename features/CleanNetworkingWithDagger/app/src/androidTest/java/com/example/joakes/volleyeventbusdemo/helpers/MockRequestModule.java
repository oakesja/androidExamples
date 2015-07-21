package com.example.joakes.volleyeventbusdemo.helpers;

import com.example.joakes.volleyeventbusdemo.GoogleStringRequest;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.*;

@Module
public class MockRequestModule {

    @Provides
    GoogleStringRequest provideGoogleStringRequest() {
        GoogleStringRequest request = mock(GoogleStringRequest.class);
        doNothing().when(request).makeRequest(anyString());
        return request;
    }
}
