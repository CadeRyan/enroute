package com.example.enrouteandroid.CustomViews;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class BusStopCell {

    public View createView(Context context, String stopID, String address)
    {

        //Update variables when layout file created
        View view = null;
        TextView tvStopID = null;
        TextView tvAddress = null;

        tvStopID.setText("Stop "+stopID);
        tvAddress.setText(address);
        if(stopID.equals(""))
        {
            tvStopID.setText("");
        }
        if(address.contains("<-->")) {
                tvStopID.setText("Route" + stopID);
    }
        return view;
    }
}
