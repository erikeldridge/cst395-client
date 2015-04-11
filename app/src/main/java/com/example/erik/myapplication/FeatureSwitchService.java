package com.example.erik.myapplication;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface FeatureSwitchService {
    @GET("/feature_switch_config")
    void getSwitches(@Query("id") int id, @Query("os") String os, @Query("version") double version, Callback<Map<String, Boolean>> callback);
}