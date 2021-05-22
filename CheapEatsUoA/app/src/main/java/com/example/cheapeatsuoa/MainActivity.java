package com.example.cheapeatsuoa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.app.Activity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {


    class ViewHolder{
        CardView cityCardView;
        CardView graftonCardView;
        CardView offCampusCardView;

        public ViewHolder() {
            cityCardView =  findViewById(R.id.card_view_city);
            graftonCardView =  findViewById(R.id.card_view_grafton);
            offCampusCardView =  findViewById(R.id.card_view_off_campus);
        }
    }

    ViewHolder vh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        vh = new ViewHolder();
        vh.cityCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent cityCampusActivity = new Intent(getBaseContext(),CityActivity.class);
                cityCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                startActivity(cityCampusActivity);
            }
        });

        vh.graftonCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent graftonCampusActivity = new Intent(getBaseContext(),GraftonActivity.class);
                graftonCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                startActivity(graftonCampusActivity);
            }
        });

        vh.offCampusCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent offCampusActivity = new Intent(getBaseContext(),OffCampusActivity.class);
                offCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                startActivity(offCampusActivity);
            }
        });

    }
}