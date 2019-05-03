package com.transport.enroute;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
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
                refresh();
            }
        });

        if (favs != null) {

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

                        removeFavourite(v);
                        refresh();

                        return true;
                    }
                });
            }
        }
    }

    private void FetchFavs(){

        loadFavourites();
        SetFavs();
    }

    private void SetFavs() {

        LinearLayout linearLayout = findViewById(R.id.favouritesLL);
        linearLayout.removeAllViews();

        if (!favsList.isEmpty()) {

            favs = new TextView[favsList.size()];
            for (int i = 0; i < favsList.size(); i++) {

                //can someone please fix the params and margins and padding, I don't know know to do this properly
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 120);
                params.setMargins(180, 60, 180, 0);

                favs[i] = new TextView(this);
                favs[i].setText(favsList.get(i).getFriendlyName());
                favs[i].setTag(favsList.get(i).getStopNumber());
                favs[i].setLayoutParams(params);
                favs[i].setBackgroundColor(Color.parseColor("#444444"));
                favs[i].setTextColor(Color.parseColor("#FFFFFF"));
                favs[i].setPadding(40, 25, 0, 0);

                linearLayout.addView(favs[i]);
            }
        }
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
    }

    private void removeFavourite(View v) {

        TextView tmp = (TextView) v;

        for(int i = 0; i < favsList.size(); i ++){
            if(favsList.get(i).getStopNumber().equals(tmp.getTag().toString())
                && favsList.get(i).getFriendlyName().equals(tmp.getText().toString())){
                favsList.remove(i);
                saveFavourites();
                break;
            }
        }

        saveFavourites();
    }

    private void refresh() {

        FetchFavs();
        SetFavsOnClick();
    }
}
