package com.acrophillic.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.acrophillic.business.User;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by fahim on 7/18/2016.
 */
public class Service implements DAO {

    DataBase database;
    Context context;
    private SQLiteDatabase sqLiteDatabase;

    public Service(Context context) {
        this.context = context;
        database = new DataBase(context);
    }

    private void open() {
        sqLiteDatabase = database.getWritableDatabase();
    }

    private void close() {
        database.close();
    }

    public String addUser(User user) {
        this.open();


        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBase.COL_FIRST_NAME, user.getFirstName());
        contentValues.put(DataBase.COL_SECOND_NAME, user.getSecondName());
        contentValues.put(DataBase.COL_EMAIL_ID, user.getEmail());
        contentValues.put(DataBase.COL_PHONE_NO, user.getPhone());

        contentValues.put(DataBase.COL_PASS, user.getPassWord());
        contentValues.put(DataBase.COL_DOB, user.getDOB().getTimeInMillis());
        contentValues.put(DataBase.COL_SEX, user.getSex());
        contentValues.put(DataBase.COL_PHOTO, user.getPicture());

        long inserted = sqLiteDatabase.insert(database.TABLE_NAME, null, contentValues);

        Log.d("fahim faysal>", inserted + "");
        Log.d("fahim faysal>", user.toString());
        this.close();

        if (inserted > 0) {
            return "Registration Successful";
        } else return "Registration Fail";
    }

    public int getUserByNamePass(String name, String pass) throws Exception {

        Log.d("Service", "name : " + name + " pass: " + pass);

        int id = 0;
        this.open();

        Cursor cursor;

        try {
//            cursor = sqLiteDatabase.query(database.TABLE_NAME, new String[]{database.COL_ID, database.COL_FIRST_NAME, database.COL_SECOND_NAME, database.COL_EMAIL_ID, database.COL_PHONE_NO, database.COL_PASS, database.COL_DOB, database.COL_SEX, database.COL_PHOTO}, "( " + database.COL_EMAIL_ID + " = " + name + " OR " + database.COL_PHONE_NO + " = " + name + " ) AND " + database.COL_PASS + " = " + pass, null, null, null, null);
            cursor = sqLiteDatabase.query(database.TABLE_NAME, new String[]{database.COL_ID, database.COL_FIRST_NAME, database.COL_SECOND_NAME, database.COL_EMAIL_ID, database.COL_PHONE_NO, database.COL_PASS, database.COL_DOB, database.COL_SEX, database.COL_PHOTO}, "( " + database.COL_EMAIL_ID + " = ?" + " OR " + database.COL_PHONE_NO + " = ?" + " ) AND " + database.COL_PASS + " = ?",new String[]{name, name, pass}, null, null, null, null);
        } catch (Exception e) {
            throw new Exception("Try again !!!!!!!!!!!!!(SQL)");
        }
        if (cursor != null && cursor.moveToFirst()) {

            id = cursor.getInt(cursor.getColumnIndex(database.COL_ID));

            String first = cursor.getString(cursor.getColumnIndex(database.COL_FIRST_NAME));
            String second = cursor.getString(cursor.getColumnIndex(database.COL_SECOND_NAME));
            Log.d("fahim faysal******", id + "++++++++++++++" + first + "++++++++++++++++++++++" + second);

            cursor.close();
        } else {
            Log.d("fahim faysal******", "no id found****" + name + "*********************************" + pass);
            cursor.close();
        }
        this.close();
        return id;
    }

    public User getUserByID(int id) {
        this.open();
        User user = null;// = new User();
        Cursor cursor = null;

        try {
            cursor = sqLiteDatabase.query(database.TABLE_NAME, new String[]{database.COL_ID, database.COL_FIRST_NAME, database.COL_SECOND_NAME, database.COL_EMAIL_ID, database.COL_PHONE_NO, database.COL_PASS, database.COL_DOB, database.COL_SEX, database.COL_PHOTO}, database.COL_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
//          cursor = sqLiteDatabase.query(database.TABLE_NAME, new String[]{database.COL_ID, database.COL_FIRST_NAME, database.COL_SECOND_NAME, database.COL_EMAIL_ID, database.COL_PHONE_NO, database.COL_PASS, database.COL_DOB, database.COL_SEX, database.COL_PHOTO}, "( " + database.COL_EMAIL_ID + " = " + name + " OR " + database.COL_PHONE_NO + " = " + name + " ) AND " + database.COL_PASS + " = " + pass, null, null, null, null);
//            android.database.sqlite.SQLiteDatabase.query(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String)' on a null object reference

        /*String selectQuery = "SELECT  * FROM " + database.TABLE_NAME + " 2   WHERE id = " + id;
        cursor = sqLiteDatabase.rawQuery(selectQuery, null);*/
        } catch (Exception e) {
            Log.d("error: ", e.getMessage());
        }
//        Log.d("sys====", "let me set here************WHO ARE YOU?----------------id: " + id);

        if (cursor != null && cursor.moveToFirst()) {

//            id = cursor.getInt(cursor.getColumnIndex(database.COL_ID));


            Long time = cursor.getLong(cursor.getColumnIndex(database.COL_DOB));
            Date date = new Date(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            user = new User(cursor.getInt(cursor.getColumnIndex(database.COL_ID)), cursor.getString(cursor.getColumnIndex(database.COL_FIRST_NAME)), cursor.getString(cursor.getColumnIndex(database.COL_SECOND_NAME)),cursor.getString(cursor.getColumnIndex(database.COL_EMAIL_ID)), cursor.getString(cursor.getColumnIndex(database.COL_PHONE_NO)), cursor.getString(cursor.getColumnIndex(database.COL_PASS)), calendar ,cursor.getString(cursor.getColumnIndex(database.COL_SEX)),cursor.getBlob(cursor.getColumnIndex(database.COL_PHOTO)));

//            String first = cursor.getString(cursor.getColumnIndex(database.COL_DOB));
//            String second = cursor.getString(cursor.getColumnIndex(database.COL_SECOND_NAME));
//          Log.d("fahim faysal******", id + "++++++++++++++" + date + "++++++++++++++++++++++" + second);

        }else {
            Log.d("sys====", "let me set here************WHO ARE YOU?");
        }

        cursor.close();
        return user;
    }

    public String updateUser(User user) {
        this.open();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBase.COL_FIRST_NAME, user.getFirstName());
        contentValues.put(DataBase.COL_SECOND_NAME, user.getSecondName());
        contentValues.put(DataBase.COL_EMAIL_ID, user.getEmail());
        contentValues.put(DataBase.COL_PHONE_NO, user.getPhone());

        contentValues.put(DataBase.COL_PASS, user.getPassWord());
        contentValues.put(DataBase.COL_DOB, user.getDOB().getTimeInMillis());
        contentValues.put(DataBase.COL_SEX, user.getSex());
        contentValues.put(DataBase.COL_PHOTO, user.getPicture());

        int updated = sqLiteDatabase.update(DataBase.TABLE_NAME, contentValues, DataBase.COL_ID + " = " + user.getId(), null);

        this.close();

        if (updated > 0) {
            return "Update successful";
        } else
            return "Update fail";
    }


}
