package com.transport.enroute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class StopSearch extends AppCompatActivity {

    TextView times;
    TextView buses;
    TextView btn;
    EditText stopNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_search);

        times = findViewById(R.id.times);
        buses = findViewById(R.id.buses);
        btn = findViewById(R.id.btnBus);
        stopNumber = findViewById(R.id.etStopNumber);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            if(extras.getString("stop_number") != null){
                GetBusTimes(extras.getString("stop_number"));
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetBusTimes(String.valueOf(stopNumber.getText()));
            }
        });
    }

    private void GetBusTimes(final String stopNumber){

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
                        timesStr += tmp.getElementsByTagName("duetime").item(0).getTextContent() + "\n";
                    }

                    buses.setText(busesStr);
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
