package com.erikeldridge.example;

import java.util.Map;

/**
 * POJO defining feature switch config
 * Instantiated by FeatureSwitchClient after parsing response
 * Instantiated by FeatureSwitchStore after reading storage
 * Provided by FeatureSwitchStore
 */
public class FeatureSwitchConfig {
    public Map<String, Boolean> config;
}