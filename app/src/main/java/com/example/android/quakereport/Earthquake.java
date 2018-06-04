package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Earthquake {
    private String mLocation;
    private double mMag;
    private String mTime;
    private String mDate;

    Earthquake(double mag, String location, int time) {
        mMag        = mag;
        mLocation   = location;

//        Setting up time data
        Date dateObj = new Date(time);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("MMM d, yyyy", Locale.US);
        mDate       = timeFormatter.format(dateObj);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("H:mm a", Locale.US);
        mTime       = dateFormatter.format(dateObj);
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

    public String getDate() {
        return mDate;
    }
}
