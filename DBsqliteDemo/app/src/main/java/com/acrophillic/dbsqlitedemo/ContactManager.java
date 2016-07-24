package com.acrophillic.dbsqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;


public class ContactManager {

    private ContactTO contactTO;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;
    private Context context;

    public ContactManager(Context context) {
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);

    }

    private void open() {
        database = dataBaseHelper.getWritableDatabase();

    }

    private void close() {
        dataBaseHelper.close();
    }

    public boolean addContact(ContactTO contactTO) {
        Log.d("Calculate Area", "hey there.................");
        this.open();

        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.COL_NAME, contactTO.getName());
        cv.put(DataBaseHelper.COL_GROUPNAME, contactTO.getGroupName());
        cv.put(DataBaseHelper.COL_PHONENO, contactTO.getPhoneNo());
        cv.put(DataBaseHelper.COL_EMAILID, contactTO.getEmailId());

        System.out.println(contactTO.getName()+"");
        Log.d("Calculate Area", contactTO.getName()+"");

        long inserted = database.insert(DataBaseHelper.TABLE_NAME, null, cv);
        this.close();

        database.close();

        if (inserted > 0) {
            return true;
        } else return false;

    }

    public ArrayList<ContactTO> getAllContacts() {

        this.open();

        ArrayList<ContactTO> contactList = new ArrayList<>();

        Cursor cursor = database.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_NAME));
                String phoneNo = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_PHONENO));

                ContactTO contactTO = new ContactTO(id, name, cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_GROUPNAME)),phoneNo,cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EMAILID)));
//                ContactTO contactTO = new ContactTO(454, "", "","","");
                contactList.add(contactTO);
                cursor.moveToNext();
            }
            this.close();

        }
        return contactList;
    }

}
