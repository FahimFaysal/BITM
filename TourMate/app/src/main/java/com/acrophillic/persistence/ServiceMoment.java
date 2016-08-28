package com.acrophillic.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.acrophillic.business.Moment;
import com.acrophillic.business.Tour;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by fahim on 8/28/2016.
 */
public class ServiceMoment {

    MomentDB database;
    Context context;
    private SQLiteDatabase sqLiteDatabase;

    public ServiceMoment(Context context) {
        this.context = context;
        database = new MomentDB(context);
    }

    private void open() {
        sqLiteDatabase = database.getWritableDatabase();
    }

    private void close() {
        database.close();
    }


    public boolean addMoment(Moment moment) {
        long inserted = 0;

            this.open();

            ContentValues contentValues = new ContentValues();

//            contentValues.put(MomentDB.COL_MOMENT_ID, moment.getTourName());
            contentValues.put(MomentDB.COL_TOUR_ID, moment.getTourId());
            contentValues.put(MomentDB.COL_MOMENT_NOTE, moment.getNote());
            contentValues.put(MomentDB.COL_PHOTO, moment.getPicture());



            inserted = sqLiteDatabase.insert(MomentDB.TABLE_NAME, null, contentValues);

            Log.d("fahim faysal>", inserted + "");
            Log.d("fahim faysal>", moment.toString());
            this.close();



        if (inserted > 0) {
            return true;
        }
        else return false;
    }


    public ArrayList<Moment> allMoment(int tourId){
        ArrayList<Moment> list = new ArrayList<>();

        this.open();
        Cursor cursor = sqLiteDatabase.query(database.TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {


            Log.e("asdf", "asdfasdf*****************");

            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {



                Moment to = new Moment();

                to.setNote(cursor.getString(cursor.getColumnIndex(MomentDB.COL_MOMENT_NOTE)));
                to.setPicture(cursor.getBlob(cursor.getColumnIndex(MomentDB.COL_PHOTO)));


                list.add(to);
                cursor.moveToNext();
            }
            this.close();

        }

        return list;
    }


}
