package com.example.erik.myapplication;

import dagger.Module;
import dagger.Provides;

@Module
class FeatureSwitchModule {

    @Provides
    FeatureSwitches provideFeatureSwitches() {
        FeatureSwitches switches = new FeatureSwitches();
        switches.isEnabled("bar");
        return switches;
    }
}