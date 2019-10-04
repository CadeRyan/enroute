package com.example.enrouteandroid.CustomViews;

import android.view.View;
import android.widget.TextView;

public class TrainStationCell {

    public View createView(String stationName)
    {
        View view = null;
        TextView tvStation = null;

        tvStation.setText(stationName);
        return view;
    }
}
