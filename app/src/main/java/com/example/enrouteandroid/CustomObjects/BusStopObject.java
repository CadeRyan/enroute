package com.example.enrouteandroid.CustomObjects;

public class BusStopObject {

    int stopID;
    String shortname;
    double lat;
    double lon;

    String routeID;
    String destination;

    BusStopObject(int stopID_, String shortname_, double lat_, double lon_){

        stopID = stopID_;
        shortname = shortname_;
        lat = lat_;
        lon = lon_;
    }

    BusStopObject(String routeID_, String destination_){

        routeID = routeID_;
        destination = destination_;
    }
}
