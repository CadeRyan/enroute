package com.transport.enroute;

import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RealtimeQuery {

    public static void GetBusTimes(final String stopNumber, final TextView route, final TextView times, final EditText searchBar){

        new Thread() {
            @Override
            public void run() {

                try{
                    searchBar.setText(stopNumber);

                    URL url = new URL("https://data.smartdublin.ie/cgi-bin/rtpi/realtimebusinformation?stopid=" + stopNumber + "&format=json");

                    Gson gson = new Gson();
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                    StopRealTime stopResult = gson.fromJson(br, StopRealTime.class);

                    String timesStr = "";
                    String busesStr = "";

                    for (RealtimeResult res : stopResult.getRealtimeResults()){

                        busesStr += res.getRoute() + "\n";
                        String dueTime = res.getDuetime();
                        switch (dueTime){
                            case("Due"):{
                                timesStr += dueTime + "\n";
                                break;
                            }
                            case("1"):{
                                timesStr += dueTime + " min" + "\n";
                                break;
                            }
                            default: {
                                timesStr += dueTime + " mins" + "\n";
                            }
                        }
                    }

                    route.setText(busesStr);
                    times.setText(timesStr);

                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void GetRouteInfo(final String routeNumber){

        new Thread() {
            @Override
            public void run() {

                try{

                    URL url = new URL("https://data.smartdublin.ie/cgi-bin/rtpi/routeinformation?routeid=" + routeNumber + "&operator=bac&format=json");

                    Gson gson = new Gson();
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                    RouteInfo routeInfo = gson.fromJson(br, RouteInfo.class);

                    for (Stop stop : routeInfo.getJourneys().get(0).getStops()){

                        System.out.println(stop.getStopid());
                    }

                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
