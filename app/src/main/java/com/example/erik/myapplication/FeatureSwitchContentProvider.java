package com.example.erik.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class FeatureSwitchContentProvider extends ContentProvider {
    static final String AUTHORITY = "com.example.erik.myapplication";
    static final Uri URI = Uri.parse("content://" + AUTHORITY + "/" + FeatureSwitchContract.TABLE_NAME);

    DatabaseHelper mHelper;

    @Override
    public boolean onCreate() {
        mHelper = new DatabaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] args, String order) {
        final SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(FeatureSwitchContract.TABLE_NAME);
        final SQLiteDatabase db = mHelper.getWritableDatabase();
        final Cursor cursor = builder.query(db, projection, selection, args, null, null, order);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final SQLiteDatabase db = mHelper.getWritableDatabase();
        final long id = db.replace(FeatureSwitchContract.TABLE_NAME, null, values);
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(FeatureSwitchContract.TABLE_NAME + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] args) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}