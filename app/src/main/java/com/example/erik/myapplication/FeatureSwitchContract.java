package com.example.erik.myapplication;

import android.provider.BaseColumns;

public final class FeatureSwitchContract implements BaseColumns {
    public static final String TABLE_NAME = "feature_switches";
    public static final String COLUMN_KEY = "key";
    public static final String COLUMN_VALUE = "value";

    static final String CREATE = "create table "
            + TABLE_NAME
            + "("
            + _ID + " integer primary key autoincrement, "
            + COLUMN_KEY + " text not null, "
            + COLUMN_VALUE + " text not null,"
            + ");";

    static final String DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;
}