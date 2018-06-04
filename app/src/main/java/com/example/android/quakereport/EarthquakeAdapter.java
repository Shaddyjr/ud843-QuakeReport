package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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

        String location = earthquake.getLocation();
        String time     = earthquake.getTime();
        String date     = earthquake.getDate();
        String mag      = String.valueOf(earthquake.getMag());

        TextView locationView   = (TextView) convertView.findViewById(R.id.location);
        TextView timeView       = (TextView) convertView.findViewById(R.id.time);
        TextView dateView       = (TextView) convertView.findViewById(R.id.date);
        TextView magView        = (TextView) convertView.findViewById(R.id.mag);

        locationView.setText(location);
        dateView.setText(date);
        timeView.setText(time);
        magView.setText(mag);

        return convertView;
    }
}
