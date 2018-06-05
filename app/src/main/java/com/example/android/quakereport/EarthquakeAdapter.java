package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Earthquake earthquake = getItem(position);

        // Magnitude
        double mag = earthquake.getMag();
        setMagnitude(mag, convertView);

        // Location
        String location = earthquake.getLocation();
        setLocation(location, convertView);

        // Time
        long time = earthquake.getTime();
        setTime(time, convertView);

        return convertView;
    }

    private void setLocation(String location, View convertView){
        String offset;
        String place;
        int sepLength = LOCATION_SEPARATOR.length();

        if(location.contains(LOCATION_SEPARATOR)) {
            int index = location.indexOf(LOCATION_SEPARATOR) + sepLength;
            offset  = location.substring(0,index);
            place = location.substring(index,location.length());
        }else{
            offset  = getContext().getString(R.string.Default_Near_Location);
            place     = location;
        }

        TextView placeView      = (TextView) convertView.findViewById(R.id.place);
        TextView distanceView   = (TextView) convertView.findViewById(R.id.distance);

        placeView.setText(place);
        distanceView.setText(offset);
    }

    private void setMagnitude(double mag, View convertView){
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magStr           = formatter.format(mag);
        TextView magView        = (TextView) convertView.findViewById(R.id.mag);
        magView.setText(magStr);
    }

    private void setTime(long time, View convertView){
        Date dateObj = new Date(time);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("MMM d, yyyy", Locale.US);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("H:mm a", Locale.US);

        TextView timeView       = (TextView) convertView.findViewById(R.id.time);
        TextView dateView       = (TextView) convertView.findViewById(R.id.date);

        dateView.setText(timeFormatter.format(dateObj));
        timeView.setText(dateFormatter.format(dateObj));
    }
}
