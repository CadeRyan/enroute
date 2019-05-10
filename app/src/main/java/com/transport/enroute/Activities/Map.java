package com.transport.enroute.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.transport.enroute.R;
import com.transport.enroute.JSONObjects.RouteInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            if(extras.get("route_name") != null){

                String routeName = extras.getString("route_name");
                new AsyncAddMarkers().execute(routeName);
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;
        LatLng dublin = new LatLng(53.340083,-6.2600715);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dublin,11));
    }

    private class AsyncAddMarkers extends AsyncTask<String, String, RouteInfo> {

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

            for (RouteInfo.Journey.Stop stop : route.getJourneys().get(0).getStops()){

                mGoogleMap.addMarker(new MarkerOptions().position
                        (new LatLng(Double.parseDouble(stop.getLatitude()), Double.parseDouble(stop.getLongitude())))
                        .title(stop.getDisplaystopid())
                        .snippet(stop.getFullname()));
            }

        }
    }
}
