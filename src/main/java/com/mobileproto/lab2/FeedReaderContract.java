package com.mobileproto.lab2;

import android.provider.BaseColumns;

/**
 * Created by wolflyra on 9/20/13.
 */
public class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NOTES = "NOTES";
        public static final String COLUMN_ID = "NOTES_ID";
        public static final String COLUMN_TITLE = "NOTE_TITLE";
        public static final String COLUMN_CONTENT = "NOTE_CONTENT";

    }
}
