package com.transport.enroute;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Favourites extends AppCompatActivity {

    TextView addNewFav;
    ArrayList<Favourite> favsList;
    TextView[] favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        addNewFav = findViewById(R.id.btnAddNewFav);
        FetchFavs();
        SetFavsOnClick();
    }

    private void SetFavsOnClick(){

        addNewFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddNewFavourite();
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

        loadFavourites();
        SetFavs();
    }

    private void SetFavs(){

        //tmp
        favs = new TextView[0];
        //

        //set the values of the TextView[] favs using ArrayList<Favourite> favsList

        AddFavsToScreen();

    }

    private void AddFavsToScreen(){

        //puts all the TextViews in TextView[] favs on screen
        //tmp
        if(favsList != null && !favsList.isEmpty()){
            String res = "";
            for(int i = 0; i < favsList.size(); i ++){

                res += favsList.get(i).getFriendlyName() + "\n"
                        + favsList.get(i).getStopNumber() + "\n";

            }

            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        }
        //
    }

    private void saveFavourites(){

        SharedPreferences sharedPrefs = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favsList);
        editor.putString("favourite stops", json);
        editor.apply();
    }

    private void loadFavourites(){

        SharedPreferences sharedPrefs = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPrefs.getString("favourite stops", null);
        Type type = new TypeToken<ArrayList<Favourite>>(){}.getType();
        favsList = gson.fromJson(json, type);

        if(favsList == null){
            favsList = new ArrayList<>();
        }
    }

    private void AddNewFavourite() {

        //provide popup for user to enter details
        //tmp
        favsList.add(new Favourite("Lucan Village", "3372"));
        favsList.add(new Favourite("Tallaght", "4647"));
        //

        saveFavourites();
        FetchFavs();
    }
}
