package com.acrophillic.api;

import android.util.Log;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fahim on 8/6/2016.
 */
public class WeatherForecast {

    static TO to = new TO();
//
    String url = "http://api.openweathermap.org/data/2.5/weather?lat=";//23.7810133&lon=90.361407&appid=8c866b47aba77a7356accfa17874fe93";


    public TO getPoetsName(double latitude, double longitude) {
        to = new TO();
        Log.e("latitude", latitude+"");
        Log.e("longitude", longitude+"");
        url += latitude+"&lon="+longitude+"&appid=8c866b47aba77a7356accfa17874fe93";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {


                try {

                    JSONObject jsonObjectMain = response.getJSONObject("main");


                    Log.e("temp*", jsonObjectMain.getDouble("temp")+"");
                    to.setTemp(jsonObjectMain.getDouble("temp"));
                    Log.e("temp*", to.getTemp()+"------------");

                    Log.e("pressure", jsonObjectMain.getString("pressure"));
                    to.setPressure(jsonObjectMain.getDouble("pressure"));

                    Log.e("humidity", jsonObjectMain.getString("humidity"));
                    to.setHumidity(jsonObjectMain.getDouble("humidity"));

                    Log.e("temp_min", jsonObjectMain.getString("temp_min"));
                    to.setTempMin(jsonObjectMain.getDouble("temp_min"));


                    Log.e("temp_max", jsonObjectMain.getString("temp_max"));
                    to.setTempMax(jsonObjectMain.getDouble("temp_max"));

                    JSONObject jsonObjectWind = response.getJSONObject("wind");
                    Log.e("speed", jsonObjectWind.getString("speed"));
                    to.setWindSpeed(jsonObjectWind.getDouble("speed"));
                    Log.e("deg", jsonObjectWind.getString("deg"));
                    to.setWindDeg(jsonObjectWind.getDouble("deg"));

                    JSONArray jsonArray = response.getJSONArray("weather");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.e("description", jsonObject.getString("description"));
                        to.setDescription(jsonObject.getString("description"));
                    }

                    JSONObject jsonObjectSys = response.getJSONObject("sys");
                    Log.e("country", jsonObjectSys.getString("country"));
                    to.setCountry(jsonObjectSys.getString("country"));

                    Log.e("name", response.getString("name"));
                    to.setName(response.getString("name"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof NoConnectionError) {

                }

            }
        });


        AppController.getInstance().addToRequestQueue(request);
//        Log.e("retun: ", string);
        Log.e("retun**: ", to.toString());
        return to;
    }

}
