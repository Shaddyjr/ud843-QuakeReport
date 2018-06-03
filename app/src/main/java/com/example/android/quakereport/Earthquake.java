package com.example.android.quakereport;

public class Earthquake {
    private String
        mLocation,
        mTime;
    private double mMag;

    public Earthquake(String location, double mag, String time) {
        mLocation   = location;
        mMag        = mag;
        mTime       = time;
    }

    public double getMag() {
        return mMag;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getTime() {
        return mTime;
    }
}
