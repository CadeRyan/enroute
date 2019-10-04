package com.example.enrouteandroid.CustomViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.enrouteandroid.R;

public class BusRTICell {

    public View createView(Context context, String routeP, String destinationP, String dueTimeP){

        View view = LayoutInflater.from(context)
        .inflate(R.layout.rti_bus_cell,null);


        TextView route = view.findViewById(R.id.tvRouteNum);
        TextView destination = view.findViewById(R.id.tvDestination);
        TextView dueTime = view.findViewById(R.id.tvDue);

        route.setText(routeP);
        destination.setText("Towards "+destinationP);
        if(dueTimeP.equalsIgnoreCase("Due"))
        {
            route.setText(routeP);
        }
        else{
            route.setText(routeP + " min");
        }

        return view;
    }

}
