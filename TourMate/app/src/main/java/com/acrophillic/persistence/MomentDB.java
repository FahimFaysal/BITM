package com.acrophillic.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fahim on 8/28/2016.
 */
public class MomentDB extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "momentDB";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "moment_table";


    public static final String COL_MOMENT_ID = "user_id";
    public static final String COL_TOUR_ID = "tour_id";

    public static final String COL_MOMENT_NOTE = "event_name";
    public static final String COL_PHOTO = "picture";


    private static final String CREATE_MOMENT_TABLE = " CREATE TABLE " + TABLE_NAME +
            "( " + COL_MOMENT_ID + " INTEGER PRIMARY KEY  ," + COL_TOUR_ID + " INTEGER, "+ COL_MOMENT_NOTE + " TEXT, "
            + COL_PHOTO + " BLOB )";


    public MomentDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public MomentDB(Context context, String name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_MOMENT_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
