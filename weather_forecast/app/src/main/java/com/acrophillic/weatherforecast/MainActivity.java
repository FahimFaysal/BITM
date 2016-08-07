package com.acrophillic.weatherforecast;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private GoogleApiClient googleApiClient;
    private Location location;
    private double latitude;
    private double longitude;

    private Activity activity;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private LocationRequest locationRequest;

    private TextView tvPlace;
    private TextView tvTemp;
    private TextView tvMaxTemp;
    private TextView tmMinTemp;
    private TextView tvWindSpeed;
    private TextView tvWindDeg;
    private TextView tvHumidity;
    private TextView tvPressure;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        googleApiClient = new GoogleApiClient.Builder(this).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();




       TO to =  new WeatherForecast().getPoetsName(latitude, longitude);


        Log.d("latitudeText",  to.toString());

        intialization();

        set(to);

    }

    public void getCurrentPlace(View view){
        TO to =  new WeatherForecast().getPoetsName(latitude, longitude);
        Log.d("latitudeText",  to.toString());
        set(to);
    }

    private void set(TO to) {
        tvPlace.setText(to.getCountry()+", "+to.getName());
        tvTemp.setText(to.getTemp()+","+to.getDescription());

        tvMaxTemp.setText("MaxTemp: "+to.getTempMax());
        tmMinTemp.setText("MinTemp: "+to.getTempMin());

        tvHumidity.setText("Humidity: "+to.getHumidity());
        tvPressure.setText("Pressure: "+to.getPressure());

        tvWindSpeed.setText("WindSpeed: "+to.getWindSpeed());
        tvWindDeg.setText("WindDeg: "+to.getWindDeg());
    }


    private void intialization() {
       tvPlace = (TextView) findViewById(R.id.textViewPlace);
         tvTemp = (TextView) findViewById(R.id.textViewTemp);
         tvMaxTemp = (TextView) findViewById(R.id.textViewMaxTemp);
        tmMinTemp = (TextView) findViewById(R.id.textViewMinTemp);
        tvWindSpeed = (TextView) findViewById(R.id.textViewWindSpeed);
         tvWindDeg = (TextView) findViewById(R.id.textViewWindDeg);
        tvHumidity = (TextView) findViewById(R.id.textViewHumidity);
         tvPressure = (TextView) findViewById(R.id.textViewPressure);
    }


    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(1000);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
            return;
        }

        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, (LocationListener) this);


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();


                } else {
//                    Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(MainActivity.this, String.valueOf(location.getLongitude()), Toast.LENGTH_SHORT).show();

        latitude = location.getLatitude();
        longitude = location.getLatitude();
//        Log.d("latitudeText", location.getLatitude() + "");
//        Log.d("longitudeText", location.getLatitude() + "");
    }
}
