package com.transport.enroute.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.transport.enroute.R;
import com.transport.enroute.RealtimeQuery;

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
                RealtimeQuery.GetBusTimes(extras.getString("stop_number"), buses, times, stopNumber);
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RealtimeQuery.GetBusTimes(String.valueOf(stopNumber.getText()), buses, times, stopNumber);
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
}
