package com.acrophillic.presentation;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.acrophillic.api.TO;
import com.acrophillic.api.TempSharedPreference;
import com.acrophillic.api.WeatherForecast;
import com.acrophillic.business.GridViewCustomAdapter;
import com.acrophillic.tourmate.R;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private Dialog dl;

    private GridViewCustomAdapter grisViewCustomAdapter;
    private Intent intent;

    private TextView textViewTemp;
    private TextView textViewDes;
    private TextView textViewLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialization();

        setWeather();


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String selectedItem;

                if (position == 0) {
                    selectedItem = "profile";
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
               /* else if(position == 1){
                    //selectedItem="Facebook";
                    Intent i = new Intent(HomeActivity.this,DivisionListActivityTwo.class);
                    startActivity(i);
                }
                else if(position == 2){
                    //selectedItem="Facebook";
                    //Toast.makeText(HomeActivity.this, "Under Updating...", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                    startActivity(i);
                }
                else if(position == 3){
                    //selectedItem="Facebook";
                    Intent i = new Intent(HomeActivity.this,DoaSuraActivity.class);
                    startActivity(i);
                }
                else if(position == 4){
                    //selectedItem="Facebook";
                    Intent i = new Intent(HomeActivity.this,AllahNameActivity.class);
                    startActivity(i);
                }
                else if(position == 5){
                    String urlToShare = "http://iboxbd.com/services/mobile-application-development/";
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                    List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
                    for (ResolveInfo info : matches) {

                        if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook")) {

                            intent.setPackage(info.activityInfo.packageName);
                            //facebookAppFound = true;
                            break;

                        }

                    }
                    startActivity(intent);
                }

                else if(position == 6){
                    //Intent i = new Intent(HomeActivity.this,AboutUsActivity.class);
                    //startActivity(i);
                    //Toast.makeText(HomeActivity.this, "Under Updating...", Toast.LENGTH_LONG).show();

                    //String deviceId = Secure.getString(this.getContentResolver(),  Secure.ANDROID_ID);
                    //Toast.makeText(HomeActivity.this, deviceId, Toast.LENGTH_SHORT).show();
                }
                else if(position == 7){
//                    Intent i = new Intent(HomeActivity.this,AboutUsActivity.class);
//                    startActivity(i);

                    //String deviceId = Secure.getString(this.getContentResolver(),  Secure.ANDROID_ID);
                    //Toast.makeText(HomeActivity.this, deviceId, Toast.LENGTH_SHORT).show();
                }*/


            }

            private ContentResolver getContentResolver() {
                // TODO Auto-generated method stub
                return null;
            }
        });
    }

    private void setWeather() {

        //        23.782956,90.357818
        TO to =  new WeatherForecast().getWeather(23.782956, 90.357818, this);

        if (to == null) {
            Log.e("weather is null", to.toString());
        } else {
            Log.e("weather", to.toString());
        }

         to =   new TempSharedPreference(this).get();


        if(to != null) {
            Double temp = to.getTemp() - 273.15;
            Log.e("weather", temp+"");

            textViewTemp.setText(to.getTemp() + ", "+ to.getDescription()+", "+to.getWindSpeed());
            textViewDes.setText(to.getTempMin() + " | " + to.getTempMax() + ", Humidity"+to.getHumidity() );
            textViewLocal.setText(to.getName() + ", " + to.getCountry());

        }
    }

    private void initialization() {
        gridView = (GridView) findViewById(R.id.gridView1);
        grisViewCustomAdapter = new GridViewCustomAdapter(this, 0);
        gridView.setAdapter(grisViewCustomAdapter);

        textViewTemp = (TextView) findViewById(R.id.textViewTemp);
        textViewDes = (TextView) findViewById(R.id.textViewDes);
        textViewLocal = (TextView) findViewById(R.id.textViewLocal);

    }
}
