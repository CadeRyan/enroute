package com.example.enrouteandroid.CustomViews;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class FavouriteCell {


    public View createView(Context context, String name, int identifier)
    {
        View view = null;
        TextView tvName = null;
        TextView tvType = null;
        TextView tvAddress = null;


        if(identifier==0)
        {
            tvName.setText("Stop: "+name);
            tvType.setText("Bus Stop");
        }
        else if(identifier==1){
            tvName.setText(name);
            tvType.setText("Train Station");

        }
        else{
            tvName.setText(name);
            tvType.setText("Luas Stop");

        }

        return view;
    }
}
