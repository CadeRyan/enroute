package com.transport.enroute.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.transport.enroute.R;
import com.transport.enroute.RealtimeQuery;

public class RouteSearch extends AppCompatActivity {

    TextView btn;

    EditText routeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_search);

        btn = findViewById(R.id.btnSearch);
        routeNumber = findViewById(R.id.etRouteNumber);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RealtimeQuery.GetRouteInfo(String.valueOf(routeNumber.getText()));
            }
        });
    }
}
