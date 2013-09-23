package com.mobileproto.lab2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wolflyra on 9/20/13.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NotesDatabase.db";
    public static final String TABLE_NOTES = "NOTES";
    public static final String COLUMN_ID = "NOTES_ID";
    public static final String COLUMN_TITLE = "NOTE_TITLE";
    public static final String COLUMN_CONTENT = "NOTE_CONTENT";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NOTES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_CONTENT + TEXT_TYPE + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Lyra", "I'm in the database helper");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.d("Lyra", "The table is recreated");
    }

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseHelper.TABLE_NOTES;


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        Log.d("Lyra", "I deleted the old database");
        onCreate(db);
        Log.d("Lyra", "I called oncreate");
    }

}

