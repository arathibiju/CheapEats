package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cheapeatsuoa.Data.DataProvider;
import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    class ViewHolder{
        CardView cityCardView;
        CardView graftonCardView;
        CardView offCampusCardView;
        SearchView searchView;

        public ViewHolder() {
            cityCardView =  findViewById(R.id.card_view_city);
            graftonCardView =  findViewById(R.id.card_view_grafton);
            offCampusCardView =  findViewById(R.id.card_view_off_campus);
            searchView =  findViewById(R.id.search_view);
        }
    }

    ViewHolder vh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        vh = new ViewHolder();
        vh.cityCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //Create a new arraylist to hold store objects
                ArrayList<Store> cityStores = DataProvider.getCityStores(); // populate array list using data provider

                Intent cityCampusIntent = new Intent(getBaseContext(),CityActivity.class);
                cityCampusIntent.putExtra("FromMainActivity", "I'm from the MainActivity");
/*                cityCampusIntent.putParcelableArrayListExtra("City", cityStores);*/
                startActivity(cityCampusIntent);
            }
        });

        vh.graftonCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ArrayList<Store> graftonStores = DataProvider.getGraftonStores(); // populate array list using data provider

                Intent graftonCampusActivity = new Intent(getBaseContext(),GraftonActivity.class);
                graftonCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                graftonCampusActivity.putParcelableArrayListExtra("Grafton" , graftonStores);
                startActivity(graftonCampusActivity);
            }
        });

        vh.offCampusCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ArrayList<Store> offCampusStores = DataProvider.getOffCampusStores();
                Intent offCampusActivity = new Intent(getBaseContext(),StoreDetailActivity.class);
                offCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                offCampusActivity.putParcelableArrayListExtra("Off" , offCampusStores );
                startActivity(offCampusActivity);
            }
        });


/*        vh.searchView.setOnSearchClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent SearchedActivity = new Intent(getBaseContext(),SearchActivity.class);
                SearchedActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                startActivity(SearchedActivity);
            }
        });*/

    }
}