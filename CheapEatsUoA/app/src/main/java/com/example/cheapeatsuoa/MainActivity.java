package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cheapeatsuoa.Data.DataProvider;
import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //Store a = new Store ( 0, "city_1", "city_1b", "city_1c", "Mojo", "HSB Courtyard, Auckland University, 10 Symonds Street");
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    Intent receiveIntent = getIntent();
    /*ArrayList<Store> recentStores = RecyclerViewAdapter.getRecentStores(this);*/
    //ArrayList<Store> recentStores = DataProvider.addRecentStores(a);
    ArrayList<Store> recentStores = DataProvider.addRecentStores(RecyclerViewAdapter.lastOnClickStore1, RecyclerViewAdapter.lastOnClickStore2, RecyclerViewAdapter.lastOnClickStore3);

    class ViewHolder{
        CardView cityCardView;
        CardView graftonCardView;
        CardView offCampusCardView;
        CardView searchDialog;
        EditText searchEditText;
        ImageView searchIcon;


        public ViewHolder() {
            cityCardView =  findViewById(R.id.card_view_city);
            graftonCardView =  findViewById(R.id.card_view_grafton);
            offCampusCardView =  findViewById(R.id.card_view_off_campus);
            searchDialog = findViewById(R.id.card_search);
            searchEditText = findViewById(R.id.search_edit_text);
            searchIcon = findViewById(R.id.search_image_icon);
        }
    }

/*    @Override
    public void onBackPressed(){
        super.onBackPressed();
        //super.recreate();
        //ArrayList<Store> recentStores = DataProvider.addRecentStores(RecyclerViewAdapter.lastOnClickStore);
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
    }*/

/*    @Override
    public void onResume() {
        this.recreate();
    }*/
    ViewHolder vh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.dark_blue_primary_dark));

        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        RecyclerView recyclerView = findViewById(R.id.top_picks_recycler_view);
        layoutManager =  new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter =  new RecyclerViewAdapter(this, R.layout.activity_main, recentStores);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        vh = new ViewHolder();

       /* vh.searchView.setQueryHint("Type your keyword here");
        vh.searchView.onActionViewExpanded();
        vh.searchView.setIconified(false);
        vh.searchView.clearFocus();

        vh.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //adapter.getFilter().filter(newText);

                return false;
            }
        });*/



        vh.cityCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //Create a new arraylist to hold store objects
                ArrayList<Store> cityStores = DataProvider.getCityStores(); // populate array list using data provider

                Intent cityCampusIntent = new Intent(getBaseContext(),CityActivity.class);
                cityCampusIntent.putExtra("FromMainActivity", "I'm from the MainActivity");
/*                cityCampusIntent.putParcelableArrayListExtra("City", cityStores);*/
                finish();
                startActivity(getIntent());
                startActivity(cityCampusIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        vh.graftonCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ArrayList<Store> graftonStores = DataProvider.getGraftonStores(); // populate array list using data provider

                Intent graftonCampusActivity = new Intent(getBaseContext(),GraftonActivity.class);
                graftonCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                graftonCampusActivity.putParcelableArrayListExtra("Grafton" , graftonStores);
                finish();
                startActivity(getIntent());
                startActivity(graftonCampusActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        vh.offCampusCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ArrayList<Store> offCampusStores = DataProvider.getOffCampusStores();
                Intent offCampusActivity = new Intent(getBaseContext(),OffCampusActivity.class);
                offCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                offCampusActivity.putParcelableArrayListExtra("Off" , offCampusStores );
                finish();
                startActivity(getIntent());
                startActivity(offCampusActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        vh.searchDialog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ArrayList<Store> offCampusStores = DataProvider.getOffCampusStores();
                ArrayList<Store> graftonStores = DataProvider.getGraftonStores();
                ArrayList<Store> cityStores = DataProvider.getCityStores();
                Intent searchActivity = new Intent(getBaseContext(),SearchActivity.class);
                searchActivity.putParcelableArrayListExtra("offcampus" , offCampusStores );
                searchActivity.putParcelableArrayListExtra("grafton" , graftonStores );
                searchActivity.putParcelableArrayListExtra("city" , cityStores );
                finish();
                startActivity(getIntent());
                startActivity(searchActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        vh.searchEditText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ArrayList<Store> graftonStores = DataProvider.getOffCampusStores();
                ArrayList<Store> cityStores = DataProvider.getCityStores();
                ArrayList<Store> offCampusStores = DataProvider.getGraftonStores();
                Intent searchActivity = new Intent(getBaseContext(),SearchActivity.class);
                searchActivity.putParcelableArrayListExtra("offcampus" , offCampusStores );
                searchActivity.putParcelableArrayListExtra("grafton" , graftonStores );
                searchActivity.putParcelableArrayListExtra("city" , cityStores );
                finish();
                startActivity(getIntent());
                startActivity(searchActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        vh.searchIcon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ArrayList<Store> graftonStores = DataProvider.getOffCampusStores();
                ArrayList<Store> cityStores = DataProvider.getCityStores();
                ArrayList<Store> offCampusStores = DataProvider.getGraftonStores();
                Intent searchActivity = new Intent(getBaseContext(),SearchActivity.class);
                searchActivity.putParcelableArrayListExtra("offcampus" , offCampusStores );
                searchActivity.putParcelableArrayListExtra("grafton" , graftonStores );
                searchActivity.putParcelableArrayListExtra("city" , cityStores );
                finish();
                startActivity(getIntent());
                startActivity(searchActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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