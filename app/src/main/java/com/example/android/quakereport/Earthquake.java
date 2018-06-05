package com.example.android.quakereport;

public class Earthquake {
    private String  mLocation;
    private double  mMag;
    private long    mTime;

    Earthquake(double mag, String location, long time) {
        mMag        = mag;
        mLocation   = location;
        mTime   = time;
    }

    public double getMag() {
        return mMag;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTime() {
        return mTime;
    }

}
