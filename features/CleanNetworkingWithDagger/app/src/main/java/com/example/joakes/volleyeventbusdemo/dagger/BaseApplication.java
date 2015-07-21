package com.example.joakes.volleyeventbusdemo.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

public class BaseApplication extends Application {
    @Singleton
    @Component(modules = {RequestModule.class})
    public interface ApplicationComponent extends IComponent {
    }

    private IComponent component = null;

    @Override public void onCreate() {
        super.onCreate();
        if (component == null) {
            component = DaggerBaseApplication_ApplicationComponent.builder()
                    .requestModule(new RequestModule(this))
                    .build();
        }
    }

    public IComponent component() {
        return component;
    }

    public void setComponent(IComponent component) {
        this.component = component;
    }
}
