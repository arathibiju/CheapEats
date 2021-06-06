package com.example.cheapeatsuoa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheapeatsuoa.Data.DataProvider;
import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.Objects;

/* README
* The classes and their inheritance shown here are different to the class diagrams in the design docs.
* More adapters were added, as at the time of making the class diagram, we were not that informed
* on the use of adapters. Other changes are related to the usage of the data provider class.
* The class diagram states that the classes would access data provider as necessary but to save
* memory we decided to pass the Store model class details as a parcelable object using intents. */


public class MainActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Store> recentStores = DataProvider.addRecentStores(RecyclerViewAdapter.lastOnClickStore1, RecyclerViewAdapter.lastOnClickStore2, RecyclerViewAdapter.lastOnClickStore3);

    // Use data provider to create arraylists for each category.
    ArrayList<Store> offCampusStores = DataProvider.getOffCampusStores();
    ArrayList<Store> graftonStores = DataProvider.getGraftonStores();
    ArrayList<Store> cityStores = DataProvider.getCityStores();

    // View Holder class to store views in the layout
    class ViewHolder{
        CardView cityCardView;
        CardView graftonCardView;
        CardView offCampusCardView;
        CardView searchDialog;
        EditText searchEditText;
        ImageView searchIcon;

        // populate views using the ID's for each view
        public ViewHolder() {
            cityCardView =  findViewById(R.id.card_view_city);
            graftonCardView =  findViewById(R.id.card_view_grafton);
            offCampusCardView =  findViewById(R.id.card_view_off_campus);
            searchDialog = findViewById(R.id.card_search);
            searchEditText = findViewById(R.id.search_edit_text);
            searchIcon = findViewById(R.id.search_image_icon);
        }
    }

    ViewHolder vh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //set the status bar to a dark blue custom colour
        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.dark_blue_primary_dark));

        //Add custom toolbar with logo
        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        // Create the recyclerview object, set adapter, set grid layout
        RecyclerView recyclerView = findViewById(R.id.top_picks_recycler_view);
        layoutManager =  new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter =  new RecyclerViewAdapter(this, R.layout.activity_main, recentStores, "MainActivity");
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        // new instance of view holder
        vh = new ViewHolder();

        // Handle click events for each category card view
        vh.cityCardView.setOnClickListener(v -> {
            Intent cityCampusIntent = new Intent(getBaseContext(),CityActivity.class);
            cityCampusIntent.putExtra("FromMainActivity", "I'm from the MainActivity");
            cityCampusIntent.putParcelableArrayListExtra("City", cityStores); // send the corresponding array list
            finish();
            startActivity(getIntent());
            startActivity(cityCampusIntent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        });

        vh.graftonCardView.setOnClickListener(v -> {
            Intent graftonCampusActivity = new Intent(getBaseContext(),GraftonActivity.class);
            graftonCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
            graftonCampusActivity.putParcelableArrayListExtra("Grafton" , graftonStores);
            finish();
            startActivity(getIntent());
            startActivity(graftonCampusActivity);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        vh.offCampusCardView.setOnClickListener(v -> {
            Intent offCampusActivity = new Intent(getBaseContext(),OffCampusActivity.class);
            offCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
            offCampusActivity.putParcelableArrayListExtra("Off" , offCampusStores );
            finish();
            startActivity(getIntent());
            startActivity(offCampusActivity);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        vh.searchDialog.setOnClickListener(v -> {
            Intent searchActivity = new Intent(getBaseContext(),SearchActivity.class);
            searchActivity.putParcelableArrayListExtra("offcampus" , offCampusStores );
            searchActivity.putParcelableArrayListExtra("grafton" , graftonStores );
            searchActivity.putParcelableArrayListExtra("city" , cityStores );
            finish();
            startActivity(getIntent());
            startActivity(searchActivity);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
        vh.searchEditText.setOnClickListener(v -> {
            Intent searchActivity = new Intent(getBaseContext(),SearchActivity.class);
            searchActivity.putParcelableArrayListExtra("offcampus" , offCampusStores );
            searchActivity.putParcelableArrayListExtra("grafton" , graftonStores );
            searchActivity.putParcelableArrayListExtra("city" , cityStores );
            finish();
            startActivity(getIntent());
            startActivity(searchActivity);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
        vh.searchIcon.setOnClickListener(v -> {
            Intent searchActivity = new Intent(getBaseContext(),SearchActivity.class);
            searchActivity.putParcelableArrayListExtra("offcampus" , offCampusStores );
            searchActivity.putParcelableArrayListExtra("grafton" , graftonStores );
            searchActivity.putParcelableArrayListExtra("city" , cityStores );
            finish();
            startActivity(getIntent());
            startActivity(searchActivity);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

    }






}