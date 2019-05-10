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
import com.transport.enroute.JSONObjects.StopRealTime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class StopSearch extends AppCompatActivity {

    TextView times;
    TextView buses;
    TextView btn;
    TextView addToFavourites;
    EditText stopNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_search);

        times = findViewById(R.id.times);
        buses = findViewById(R.id.buses);
        btn = findViewById(R.id.btnBus);
        addToFavourites = findViewById(R.id.btnAddToFavourites);
        stopNumber = findViewById(R.id.etStopNumber);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            if(extras.getString("stop_number") != null){
                new AsyncGetBusTimes().execute(extras.getString("stop_number"));
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AsyncGetBusTimes().execute(String.valueOf(stopNumber.getText()));
            }
        });

        addToFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputText = String.valueOf(stopNumber.getText());

                if(!inputText.equals("") && inputText != null){

                    Intent addToFavourites = new Intent(StopSearch.this, Favourites.class);
                    addToFavourites.putExtra("new_favourite", inputText);
                    startActivity(addToFavourites);
                }
            }
        });
    }

    private class AsyncGetBusTimes extends AsyncTask<String, String, StopRealTime> {

        @Override
        protected StopRealTime doInBackground(String... strings) {

            try{
                URL url = new URL("https://data.smartdublin.ie/cgi-bin/rtpi/realtimebusinformation?stopid=" + strings[0] + "&format=json");
                Gson gson = new Gson();
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                StopRealTime stopResult = gson.fromJson(br, StopRealTime.class);

                return stopResult;

            }catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(StopRealTime stop) {
            super.onPostExecute(stop);

            stopNumber.setText(stop.getStopid());

            String timesStr = "";
            String busesStr = "";

            for (StopRealTime.RealtimeResult res : stop.getRealtimeResults()){

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

            buses.setText(busesStr);
            times.setText(timesStr);
        }
    }
}
