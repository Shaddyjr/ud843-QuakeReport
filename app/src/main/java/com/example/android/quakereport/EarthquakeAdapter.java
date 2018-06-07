package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        TextView locationView      = (TextView) convertView.findViewById(R.id.primary_location);
        TextView offsetView   = (TextView) convertView.findViewById(R.id.location_offset);

        locationView.setText(place);
        offsetView.setText(offset);
    }

    private void setMagnitude(double mag, View convertView){
        // background color
        int magColorID             = getMagBackground(mag);
        int magColor               = ContextCompat.getColor(getContext(), magColorID);
        TextView magCircleView     = (TextView) convertView.findViewById(R.id.magnitude);
        GradientDrawable magCircle = (GradientDrawable) magCircleView.getBackground();
        magCircle.setColor(magColor);

        // text
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magStr           = formatter.format(mag);
        magCircleView.setText(magStr);
    }

    private int getMagBackground(double mag){
        int magVal = (int)Math.floor(mag);
        int colorID;
        // Found switch excessive
//        Context context = getContext();
//        magVal = magVal > 10? 10 : magVal;
//        return context.getResources().getIdentifier("magnitude"+ magVal ,"color", context.getPackageName());
        switch(magVal){
            case 0:
            case 1:
                colorID = R.color.magnitude1;
                break;
            case 2:
                colorID = R.color.magnitude2;
                break;
            case 3:
                colorID = R.color.magnitude3;
                break;
            case 4:
                colorID = R.color.magnitude4;
                break;
            case 5:
                colorID = R.color.magnitude5;
                break;
            case 6:
                colorID = R.color.magnitude6;
                break;
            case 7:
                colorID = R.color.magnitude7;
                break;
            case 8:
                colorID = R.color.magnitude8;
                break;
            case 9:
                colorID = R.color.magnitude9;
                break;
            default:
                colorID = R.color.magnitude10;
                break;
        }
        return colorID;
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
