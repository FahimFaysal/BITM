package com.acrophillic.trackmyroad;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class GpsActivity extends FragmentActivity implements OnMapReadyCallback {

    private boolean status;
    private GoogleMap googleMap;
    private GoogleMap mMap;
    Polyline polyline ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.clear();

        ArrayList<LatLng> latLngList = new ArrayList<>();
        ArrayList<GPS> GpsList;
        try {
            GpsList =  new FileReadWrite(this).readFromFile();

            Log.e("list0: ", GpsList.toString());

            for(int i = 0; i<GpsList.size()-1; i++){

                LatLng latLng=new LatLng(GpsList.get(i).getLatitude(),GpsList.get(i).getLongitude());
                latLngList.add(latLng);


                mMap.addMarker(new MarkerOptions().position(latLng).title(i+1+": "+GpsList.get(i).getLocationName()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            }


        }catch (java.lang.Exception e){
            e.printStackTrace();
        }



        if(!latLngList.isEmpty()) {
            Log.e("list: ", latLngList.toString());
//    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngList.get(0).,latLngList.get(0).getLongitude()));
            redrawLine(latLngList);
        }

    }


    private void drawLine(Marker marker1, Marker marker2) {
        PolylineOptions polylineOptions = new PolylineOptions().add(marker1.getPosition()).add(marker2.getPosition()).color(Color.BLUE).width(5);
        polyline = googleMap.addPolyline(polylineOptions);
    }


    private void redrawLine(ArrayList<LatLng> latLngList){


        PolylineOptions polylineOptions = new PolylineOptions().width(8).color(Color.GREEN).geodesic(true);
        for (int i = 0; i < latLngList.size(); i++) {
            polylineOptions.add( latLngList.get(i));
            mMap.addMarker(new MarkerOptions().position(latLngList.get(i)));
        }

        Polyline line = mMap.addPolyline(polylineOptions);
    }




    public void startService(View view) {
        Intent intent = new Intent(this, GpsService.class);
        startService(intent);

    }

    public void pauseService(View view) {
        new FileReadWrite(this).delete();
    }

    public void listPlace(View view) {
        Intent intent = new Intent(this, PlaceActivity.class);
        startActivity(intent);
    }


    public void stopService(View view) {    //♀
        Intent intent = new Intent(this, GpsService.class);
        stopService(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        System.exit(0);
    }
}
