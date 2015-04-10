package com.example.erik.myapplication;

import android.support.v7.app.ActionBarActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {FeatureSwitchModule.class})
public interface FeatureSwitchComponent {
    FeatureSwitches makeSwitches();
}