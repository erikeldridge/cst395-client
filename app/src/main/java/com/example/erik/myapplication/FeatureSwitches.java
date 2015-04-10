package com.example.erik.myapplication;

import javax.inject.Inject;

class FeatureSwitches {

    @Inject
    public FeatureSwitches() {
    }

    public boolean isEnabled(String key) {
        return true;
    }
}