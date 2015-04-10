package com.example.erik.myapplication;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

public class App extends Application {
    private FeatureSwitchComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerFeatureSwitchComponent.builder()
                .featureSwitchModule(new FeatureSwitchModule())
                .build(); // As of now, LocationManager should be injected into this.
    }

    public FeatureSwitchComponent component() {
        return component;
    }
}