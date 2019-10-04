package com.example.enrouteandroid.CustomViews;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.example.enrouteandroid.R;

public class LuasStopCell {

    public View createView(Context context, String stopName, int lineNum)
    {
        View view = null;
        TextView tvLineName = null;
        TextView tvStopName = null;

        if(lineNum==0)
        {
            tvLineName.setText("Green Line");
            tvLineName.setTextColor(context.getResources().getColor(R.color.green));
        }
        else
        {
            tvLineName.setText("Red Line");
            tvLineName.setTextColor(context.getResources().getColor(R.color.red));
        }

        return view;
    }
}
