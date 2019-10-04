package com.example.enrouteandroid.CustomObjects;

import java.util.ArrayList;

public class BusRouteObject {

    String destination;
    String stopID;
    double lat;
    double lon;
    String address;
    ArrayList<BusRouteObject> stops;

    BusRouteObject(String destination_, ArrayList<BusRouteObject> stops_){

        destination = destination_;
        stops = stops_;
    }

    BusRouteObject(String stopID_, String address_, String lat_, String lon_) {

        stopID = stopID_;
        address = address_;
        lat = Double.parseDouble(lat_);
        lon = Double.parseDouble(lon_);
    }
}
