//package com.erikeldridge.myapplication;
//
//import android.content.ContentQueryMap;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteQueryBuilder;
//import android.util.Log;
//
//import java.util.Map;
//import java.util.concurrent.Executor;
//import java.util.concurrent.Executors;
//
//import retrofit.Callback;
//import retrofit.RestAdapter;
//import retrofit.RetrofitError;
//import retrofit.client.Response;
//
//public class FeatureSwitchStore {
//    static final String TAG = "FeatureSwitchStore";
//    final Context mContext;
//    final ContentQueryMap mSwitches;
//
//    public boolean isEnabled(String key) {
//        return mSwitches.getValues(key).getAsBoolean(FeatureSwitchContract.COLUMN_VALUE);
//    }
//
//    public FeatureSwitchStore(Context context) {
//        mContext = context;
//        mSwitches = load();
//        fetchAndStore();
//    }
//
//    public ContentQueryMap load() {
//
//    }
//
//    public void fetchAndStore() {
//
//    }
//}