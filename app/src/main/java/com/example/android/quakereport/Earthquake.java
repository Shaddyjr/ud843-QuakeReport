package com.example.android.quakereport;

public class Earthquake {
    private String  mLocation;
    private double  mMag;
    private long    mTime;
    private String  mUrl;

    Earthquake(double mag, String location, long time, String url) {
        mMag        = mag;
        mLocation   = location;
        mTime       = time;
        mUrl        = url;
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

    public String getUrl() {
        return mUrl;
    }
}
