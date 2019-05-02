package com.transport.enroute;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Favourites extends AppCompatActivity {

    TextView addNewFav;
    TextView[] favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        //tmp
        favs = new TextView[0];
        //

        addNewFav = findViewById(R.id.btnAddNewFav);
        FetchFavs();
        SetFavsOnClick();
    }

    private void SetFavsOnClick(){

        addNewFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //launches popup for the user to enter stop number and friendly name

                System.out.println("Add new favourite");

            }
        });

        for(int i = 0; i < favs.length; i ++){

            favs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent startSearch = new Intent(Favourites.this, StopSearch.class);
                    startSearch.putExtra("stop_number", v.getTag().toString());
                    startActivity(startSearch);

                    System.out.println("short press");
                }
            });

            favs[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    //this will provide te user with a popup to delete this from their favourites

                    System.out.println("long press");
                    return true;
                }
            });
        }
    }

    private void FetchFavs(){

        NodeList favourites = null;
        //retrieve favourites from xml in storage and store here in memory as a NodeList favourites
        
        //example of what the xml file containing the favs data should look like:

        //<favourites>
        //  <favourite>
        //      <stopNumber>4647</stopNumber>
        //      <friendlyName>Tallaght to town</friendlyName>
        //  </favourite>
        //  <favourite>
        //      <stopNumber>3372</stopNumber>
        //      <friendlyName>Lucan Village</friendlyName>
        //  </favourite>
        //</favourites>

        SetFavs(favourites);
    }

    private void SetFavs(NodeList favourites){

        //uses NodeList favourites to parse the friendly names and set the params of the favs TextView[]
        //tags each TextView in favs with its stopNumber eg. tags[i].setTag(String stopNumber)

        AddFavsToScreen();
    }

    private void AddFavsToScreen(){

        //puts all the TextViews in TextView[] favs on screen
    }
}
