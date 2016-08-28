package com.acrophillic.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fahim on 8/27/2016.
 */
public class TourDB extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "tourDB";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "tour_table";


    public static final String COL_USER_ID = "user_id";
    public static final String COL_TOUR_ID = "tour_id";
    public static final String COL_EVENT_NAME = "event_name";
    public static final String COL_START_PLACE = "first_place";
    public static final String COL_VISITING_PLACE = "visiting_place";
    public static final String COL_START_DATE = "start_date";
    public static final String COL_END_DATE = "end_date";
    public static final String COL_BUDGET = "budget";
    public static final String COL_COST = "cost";


    private static final String CREATE_TOUR_TABLE = " CREATE TABLE " + TABLE_NAME +
            "( " + COL_TOUR_ID + " INTEGER PRIMARY KEY  ," + COL_USER_ID + " INTEGER, "+ COL_EVENT_NAME + " TEXT, "+ COL_START_PLACE + " TEXT, "+COL_VISITING_PLACE + " TEXT, "+ COL_START_DATE + " calendar, "+ COL_END_DATE + " calendar, "+ COL_BUDGET + " INTEGER, "
            + COL_COST + " TEXT )";


    public TourDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public TourDB(Context context, String name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TOUR_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
