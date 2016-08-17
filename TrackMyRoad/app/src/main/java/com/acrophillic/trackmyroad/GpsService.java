package com.acrophillic.trackmyroad;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;

import com.google.android.gms.common.api.GoogleApiClient;


import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.vision.barcode.Barcode;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GpsService extends Service implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {



    GoogleApiClient googleApiClient;
    Location location;
    private static final int PERMISSION_REQUEST_CODE = 1;
    LocationRequest locationRequest;
    Context context = this;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        googleApiClient.connect();

        return START_REDELIVER_INTENT;

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        Toast.makeText(GpsService.this, "Fused Location Connected.", Toast.LENGTH_LONG).show();

        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);


    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(GpsService.this, "Permission granted", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(GpsService.this, "Permission denied", Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        if (location != null) {



            try{
                String st  = geoLocate(location.getLatitude(), location.getLongitude());

                GPS gps = new GPS(location.getLatitude(),location.getLongitude(),st);

                new FileReadWrite(context).writeToFile(gps);

                Toast.makeText(GpsService.this, location.getLatitude()+", "+location.getLongitude()+"-"+st, Toast.LENGTH_SHORT).show();

            }catch (Exception e){

                e.printStackTrace();
            }



//            String getlatitudeText = Double.toString(location.getLatitude());
//            String getlongitudeText = (String.valueOf(location.getLongitude()));
        }


    }



    public String geoLocate(double latitude, double longitude) throws IOException {

//        Geocoder geocoder = new Geocoder(context, Locale.getDefault());

        Geocoder gcd = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = gcd.getFromLocation(latitude, longitude, 1);
        Address address = addresses.get(0);

        String stLocality = address.getLocality();

        return stLocality;

    }

    @Override
    public void onDestroy() {

        googleApiClient.disconnect();
        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
