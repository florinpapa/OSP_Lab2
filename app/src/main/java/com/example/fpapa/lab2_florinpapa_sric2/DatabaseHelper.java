package com.example.fpapa.lab2_florinpapa_sric2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fpapa on 24-Oct-16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "menu.db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS menu (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "desc TEXT," +
                "price INTEGER" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS menu");
        onCreate(db);
    }
}
