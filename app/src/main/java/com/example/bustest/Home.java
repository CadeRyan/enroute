package com.example.bustest;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Home extends AppCompatActivity {

    TextView times;
    TextView btn;
    EditText stopNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        times = findViewById(R.id.results);
        btn = findViewById(R.id.btnBus);
        stopNumber = findViewById(R.id.etStopNumber);

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

                    DocumentBuilderFactory documentBuildFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuildFactory.newDocumentBuilder();
                    Document doc = documentBuilder.parse(url.openStream());

                    NodeList results = doc.getElementsByTagName("result");

                    System.out.println(results.getLength());
                    ArrayList<String> res = new ArrayList<>();
                    String busTimes = "";

                    for (int i = 0; i < results.getLength(); i ++){

                        //System.out.println(results.item(i).getTextContent());

                        Element tmp = (Element) results.item(i);
                        res.add(tmp.getElementsByTagName("duetime").item(0).getTextContent());
                        busTimes += tmp.getElementsByTagName("route").item(0).getTextContent() + "    ";
                        busTimes += tmp.getElementsByTagName("duetime").item(0).getTextContent() + "\n";
                    }

//                    for (int i = 0; i < res.size(); i ++){
//                        busTimes += res.get(i) + "\n";
//                    }

                    times.setText(busTimes);

                }catch (ParserConfigurationException | IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
