package com.transport.enroute;

import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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

                    for (Result res : stopResult.getResults()){

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
}
