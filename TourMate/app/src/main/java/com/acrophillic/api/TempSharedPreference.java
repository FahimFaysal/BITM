package com.acrophillic.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by fahim on 8/27/2016.
 */
public class TempSharedPreference {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

   public TempSharedPreference (Context context){
        preferences = context.getSharedPreferences("tempPref", context.MODE_PRIVATE);
        editor = preferences.edit();
        gson = new Gson();
    }

   public void set(TO temp){

       Log.e("pref", temp.toString());

       String json = gson.toJson(temp);
       editor.putString("temp", json);
       editor.commit(); // commit changes
    }

    public TO get(){
        String json = preferences.getString("temp", "");
//        Log.e("pref", gson.fromJson(json, TO.class).toString());
        return gson.fromJson(json, TO.class);
    }

}
