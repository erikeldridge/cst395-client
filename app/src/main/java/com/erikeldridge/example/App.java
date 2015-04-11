package com.erikeldridge.example;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.content.ContentQueryMap;
import android.util.Log;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class App extends Application {
    static final String TAG = "Application";
    public ContentQueryMap mSwitches;

    public boolean isEnabled(String key) {
        ContentValues values = mSwitches.getValues(key);
        return values != null && values.getAsInteger(FeatureSwitchContract.COLUMN_VALUE) == 1;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        final SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(FeatureSwitchContract.TABLE_NAME);
        final DatabaseHelper helper = new DatabaseHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();
        final Cursor cursor = builder.query(db, new String[] {}, null, null, null, null, null);
        mSwitches = new ContentQueryMap(cursor, FeatureSwitchContract.COLUMN_KEY, true, null);
        Executor executor = Executors.newCachedThreadPool();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://young-depths-7217.herokuapp.com")
                .setExecutors(executor, executor)
                .build();
        FeatureSwitchService service = restAdapter.create(FeatureSwitchService.class);
        service.getSwitches(123, "android", 2.3, new Callback<Map<String, Boolean>>() {
            @Override
            public void success(Map<String, Boolean> config, Response response) {
                for (Map.Entry<String, Boolean> entry: config.entrySet()) {
                    ContentValues values = new ContentValues();
                    values.putNull(FeatureSwitchContract._ID);
                    values.put(FeatureSwitchContract.COLUMN_KEY, entry.getKey());
                    values.put(FeatureSwitchContract.COLUMN_VALUE, entry.getValue() ? 1 : 0);
                    getApplicationContext().getContentResolver().insert(FeatureSwitchContentProvider.URI, values);
                    db.replace(FeatureSwitchContract.TABLE_NAME, null, values);
                }
                helper.close();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.toString());
            }
        });
    }
}