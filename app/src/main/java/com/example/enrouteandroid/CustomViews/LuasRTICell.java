package com.example.enrouteandroid.CustomViews;

import android.view.View;
import android.widget.TextView;

public class LuasRTICell {


    public View createView(String destination, String dueTime)
    {
        View view = null;
        TextView tvDestination = null;
        TextView tvDue = null;

        tvDestination.setText(destination);
        tvDue.setText(dueTime);

     return view;
    }
}
