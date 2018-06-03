package com.example.android.quakereport;

public class Earthquake {
    private String mLocation;
    private double mMag;
    private int mTime;

    Earthquake(double mag, String location, int time) {
        mMag        = mag;
        mLocation   = location;
        mTime       = time;
    }

    public double getMag() {
        return mMag;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getTime() {
        return mTime;
    }
}
