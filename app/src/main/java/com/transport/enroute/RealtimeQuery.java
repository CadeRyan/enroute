package com.transport.enroute;

import android.widget.TextView;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class RealtimeQuery {

    public static void GetBusTimes(final String stopNumber, final TextView route, final TextView times){

        new Thread() {
            @Override
            public void run() {

                try{
                    URL url = new URL("https://data.smartdublin.ie/cgi-bin/rtpi/realtimebusinformation?stopid=" + stopNumber + "&format=xml");
                    NodeList results = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url.openStream()).getElementsByTagName("result");

                    String timesStr = "";
                    String busesStr = "";

                    for (int i = 0; i < results.getLength(); i ++){

                        Element tmp = (Element) results.item(i);
                        busesStr += tmp.getElementsByTagName("route").item(0).getTextContent() + "\n";
                        String dueTime = tmp.getElementsByTagName("duetime").item(0).getTextContent();
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

                    if (busesStr.equals("")) {
                        busesStr += "No results";
                    }

                    route.setText(busesStr);
                    times.setText(timesStr);

                }catch (ParserConfigurationException | IOException e) {
                    e.printStackTrace();
                }catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
