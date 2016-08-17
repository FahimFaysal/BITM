package com.acrophillic.trackmyroad;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fahim on 8/13/2016.
 */
public class DataSharedPreference {


    private static String KEY_STATUS = "status";


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public  DataSharedPreference(Context context){
        sharedPreferences = context.getSharedPreferences("trackerSharedPreferences", context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public void set(int i){
        editor.putInt("KEY_STATUS", i);
        editor.commit();
    }

    public int get(){
        return sharedPreferences.getInt("KEY_STATUS", 0);
    }


}
