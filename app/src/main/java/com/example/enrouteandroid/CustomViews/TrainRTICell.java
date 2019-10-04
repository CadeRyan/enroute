package com.example.enrouteandroid.CustomViews;

import android.view.View;
import android.widget.TextView;

public class TrainRTICell {


    public View createView(String destination, String status, String due)
    {
        View view = null;
        TextView tvDestination = null;
        TextView tvStatus = null;
        TextView tvDue = null;

        tvDestination.setText(destination);
        tvStatus.setText(status);
        tvDue.setText(due);

        return view;
    }
}
