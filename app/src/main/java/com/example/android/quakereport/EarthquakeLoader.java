package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String mUrl;
    EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    // Needed to kick off loader
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if(mUrl.length()<1 || mUrl==null) return null;
        return QueryUtils.fetchEarthquakeData(mUrl);
    }
}
