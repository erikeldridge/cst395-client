package com.example.erik.myapplication;

import dagger.Module;
import dagger.Provides;

@Module
class FeatureSwitchModule {

    @Provides
    public FeatureSwitches provide() {
        FeatureSwitches switches = new FeatureSwitches();
        switches.isEnabled("bar");
        return switches;
    }
}