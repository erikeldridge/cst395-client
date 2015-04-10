package com.example.erik.myapplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {FeatureSwitchModule.class})
public interface FeatureSwitchComponent {
    public void inject(MainActivity activity);
}