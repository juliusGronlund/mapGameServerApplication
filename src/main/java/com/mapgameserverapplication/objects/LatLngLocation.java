package com.mapgameserverapplication.objects;

public class LatLngLocation {
    public double latitude, longitude;

    public LatLngLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String toReturnString() {
        return latitude + ":" + longitude;
    }

    @Override
    public String toString() {
        return "LatLngLocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
