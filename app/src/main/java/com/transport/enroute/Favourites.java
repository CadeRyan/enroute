package com.transport.enroute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Favourites extends AppCompatActivity {

    TextView[] favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        //need to set up the add new fav button to launch a popup for the user to add the stop number
        //and friendly name of the stop. This then needs to be stored in memory and the list of
        //favs on screen should be refreshed.

        // here I need to read in the pre-existing favs from somewhere in storage and load them into an
        // array of text views on the screen, also set up the click listeners for the view array

        favs[0] = findViewById(R.id.btnFav);

        favs[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this will launch the real-time query with the stop data pre-loaded

                System.out.println("short press");
            }
        });

        favs[0].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //this will provide te user with a popup to delete this from their favourites

                System.out.println("long press");
                return true;
            }
        });

    }
}
