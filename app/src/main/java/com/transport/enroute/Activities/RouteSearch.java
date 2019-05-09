package com.transport.enroute.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.transport.enroute.R;
import com.transport.enroute.RouteInfo;
import com.transport.enroute.Stop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class RouteSearch extends AppCompatActivity {

    TextView btnSearch;
    TextView test;
    TextView btnViewOnMap;
    EditText routeNumber;

    RouteInfo searchedRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_search);

        btnSearch = findViewById(R.id.btnSearch);
        btnViewOnMap = findViewById(R.id.btnViewRouteOnMap);
        test = findViewById(R.id.testBox);
        routeNumber = findViewById(R.id.etRouteNumber);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AsyncGetRouteInfo().execute(String.valueOf(routeNumber.getText()));
            }
        });
        btnViewOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnViewOnMap.setVisibility(View.INVISIBLE);
                Intent viewRouteOnMap = new Intent(RouteSearch.this, Map.class);
                viewRouteOnMap.putExtra("route_name", searchedRoute.getRoute());
                startActivity(viewRouteOnMap);
            }
        });
    }

    private class AsyncGetRouteInfo extends AsyncTask<String, String, RouteInfo> {

        @Override
        protected RouteInfo doInBackground(String... strings) {

            try {
                URL url = new URL("https://data.smartdublin.ie/cgi-bin/rtpi/routeinformation?routeid=" + strings[0] + "&operator=bac&format=json");
                Gson gson = new Gson();
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                RouteInfo routeInfo = gson.fromJson(br, RouteInfo.class);

                return routeInfo;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(RouteInfo route) {
            super.onPostExecute(route);

            String stopIDs = "";

            for (Stop stop : route.getJourneys().get(0).getStops()){

                stopIDs += stop.getStopid() + ", ";
            }
            searchedRoute = route;
            btnViewOnMap.setVisibility(View.VISIBLE);
            test.setText(stopIDs);
        }
    }
}
