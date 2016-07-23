package com.acrophillic.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fahim on 7/18/2016.
 */


public class DataBase extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "userDB";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "user_table";


    public static final String COL_ID = "id";
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_SECOND_NAME = "second_name";
    public static final String COL_EMAIL_ID = "email_id";
    public static final String COL_PHONE_NO = "phone_no";
    public static final String COL_PASS = "password";
    public static final String COL_DOB = "date_of_birth";
    public static final String COL_SEX = "sex";
    public static final String COL_PHOTO = "picture";



    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_CONTACT_TABLE = " CREATE TABLE " + TABLE_NAME +
            "( " + COL_ID + " INTEGER PRIMARY KEY," + COL_FIRST_NAME + " TEXT, "+COL_SECOND_NAME + " TEXT, "+ COL_EMAIL_ID + " TEXT, "+ COL_PHONE_NO + " TEXT, "+ COL_PASS + " TEXT, "+ COL_DOB + " calendar, "+ COL_SEX + " TEXT, "
            + COL_PHOTO + " BLOB )";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
