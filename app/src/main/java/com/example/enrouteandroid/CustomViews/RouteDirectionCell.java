package com.example.enrouteandroid.CustomViews;

import android.view.View;
import android.widget.TextView;

public class RouteDirectionCell {

    public View createView(String destination)
    {
        View view = null;
        TextView tvDestination = null;

        tvDestination.setText("Towards "+destination);
        return view;
    }
}
