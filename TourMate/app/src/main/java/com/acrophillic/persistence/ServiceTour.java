package com.acrophillic.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
public class ServiceTour {

    TourDB database;
    Context context;
    private SQLiteDatabase sqLiteDatabase;

    public ServiceTour(Context context) {
        this.context = context;
        database = new TourDB(context);
    }

    private void open() {
        sqLiteDatabase = database.getWritableDatabase();
    }

    private void close() {
        database.close();
    }


    public boolean addTour(Tour tour) {
        long inserted = 0;
        try {
            this.open();

            ContentValues contentValues = new ContentValues();

            contentValues.put(TourDB.COL_EVENT_NAME, tour.getTourName());
            contentValues.put(TourDB.COL_USER_ID, tour.getUsrId());
            contentValues.put(TourDB.COL_START_PLACE, tour.getFromPlace());
            contentValues.put(TourDB.COL_VISITING_PLACE, tour.getToPlace());

            contentValues.put(TourDB.COL_START_DATE, tour.getStartDate().getTimeInMillis());
            contentValues.put(TourDB.COL_END_DATE, tour.getEndDate().getTimeInMillis());


            contentValues.put(TourDB.COL_BUDGET, tour.getBudget());

            JSONObject json = new JSONObject();
            json.put("uniqueArrays", new JSONArray(tour.getCostArrayList()));
            String arrayList = json.toString();

            contentValues.put(TourDB.COL_COST, arrayList);

             inserted = sqLiteDatabase.insert(TourDB.TABLE_NAME, null, contentValues);

            Log.d("fahim faysal>", inserted + "");
            Log.d("fahim faysal>", tour.toString());
            this.close();


        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (inserted > 0) {
            return true;
        }
        else return false;
    }


    public ArrayList<Tour> allTour(int userId){
        ArrayList<Tour> list = new ArrayList<>();

        this.open();
        Cursor cursor = sqLiteDatabase.query(database.TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {


            Log.e("asdf", "asdfasdf*****************");

            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {

                /*int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_));
                String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_NAME));
                String phoneNo = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_PHONENO));*/

                Tour to = new Tour();

                to.setTourName(cursor.getString(cursor.getColumnIndex(TourDB.COL_EVENT_NAME)));
                to.setBudget(cursor.getInt(cursor.getColumnIndex(TourDB.COL_BUDGET)));
                to.setToPlace(cursor.getString(cursor.getColumnIndex(TourDB.COL_START_PLACE)));
                to.setFromPlace(cursor.getString(cursor.getColumnIndex(TourDB.COL_VISITING_PLACE)));


                Long time = cursor.getLong(cursor.getColumnIndex(TourDB.COL_START_DATE));
                Date date = new Date(time);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                to.setStartDate(calendar);

                Long time2 = cursor.getLong(cursor.getColumnIndex(TourDB.COL_END_DATE));
                Date date2 = new Date(time2);
                Calendar calendar2 = Calendar.getInstance();
                calendar.setTime(date2);

                to.setEndDate(calendar2);



                list.add(to);
                cursor.moveToNext();
            }
            this.close();

        }

        return list;
    }


}
