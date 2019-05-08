package com.transport.enroute.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.transport.enroute.R;

public class Home extends AppCompatActivity {

    TextView favourites;
    TextView searchByStop;
    TextView searchByRoute;
    EditText stopNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchByStop = findViewById(R.id.btnSearchByStop);
        searchByRoute = findViewById(R.id.btnSearchByRoute);
        favourites = findViewById(R.id.btnFavs);
        stopNumber = findViewById(R.id.etStopNumber);

        searchByStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startSearch = new Intent(Home.this, StopSearch.class);
                startActivity(startSearch);
            }
        });

        searchByRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startSearch = new Intent(Home.this, RouteSearch.class);
                startActivity(startSearch);
            }
        });

        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startFavs = new Intent(Home.this, Favourites.class);
                startActivity(startFavs);
            }
        });
    }
}
