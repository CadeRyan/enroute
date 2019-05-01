package com.transport.enroute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
                RealtimeQuery.GetBusTimes(extras.getString("stop_number"), buses, times);
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RealtimeQuery.GetBusTimes(String.valueOf(stopNumber.getText()), buses, times);
            }
        });
    }
}
