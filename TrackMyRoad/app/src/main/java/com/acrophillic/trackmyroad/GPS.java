package com.acrophillic.trackmyroad;

/**
 * Created by fahim on 8/15/2016.
 */
public class GPS {

    private double latitude;
    private double longitude;
    private String locationName;


    public GPS(double latitude, double longitude, String locationName) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
    }

 public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return latitude+","+longitude+","+locationName+";";
    }
}
