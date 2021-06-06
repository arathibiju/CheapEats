package com.example.cheapeatsuoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.cheapeatsuoa.Model.Store;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import static com.example.cheapeatsuoa.RecyclerViewAdapter.lastOnClickStore1;
import static com.example.cheapeatsuoa.RecyclerViewAdapter.lastOnClickStore2;
import static com.example.cheapeatsuoa.RecyclerViewAdapter.lastOnClickStore3;

public class SearchActivity extends AppCompatActivity {

    ListViewAdapter adapter;
    ArrayList<Store> offCampus = new ArrayList<>();
    ArrayList<Store> grafton = new ArrayList<>();
    ArrayList<Store> city = new ArrayList<>();

    class ViewHolder {
        SearchView searchView;
        ListView listView;
        TextView results;

        public ViewHolder() {
            searchView = findViewById(R.id.search_view);
            listView = findViewById(R.id.list);
            results = findViewById(R.id.results_text);
        }
    }
    ViewHolder vh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Window window = SearchActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(SearchActivity.this, R.color.dark_blue_primary_dark));

        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        vh = new ViewHolder();

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        offCampus =  intent.getParcelableArrayListExtra("offcampus");
        grafton =  intent.getParcelableArrayListExtra("grafton");
        city =  intent.getParcelableArrayListExtra("city");


        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, offCampus, grafton, city);
        vh.listView.setAdapter(adapter);


        vh.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                boolean flag = adapter.filter(query);
               /* if (!flag){
                    Snackbar.make(findViewById(R.id.CoordinatorLayout), "No Results Found",
                            Snackbar.LENGTH_LONG)
                            .show();


                }*/
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                boolean flag = adapter.filter(s);
                if (!flag){
                    vh.results.setText("No Results Found");


                } else{
                    vh.results.setText("");
                }

                return false;
            }
        });

        setupStoreSelectedListener();
    }

    public void setupStoreSelectedListener() {
        vh.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing store as an extra
                Intent intent = new Intent(SearchActivity.this, StoreDetailActivity.class);
                intent.putExtra("FromActivity", adapter.getItem(position)); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                startActivity(intent);

                //updates recently visited stores//
                if (( adapter.getItem(position).getStoreName()).equals(lastOnClickStore1.getStoreName())){

                }
                else if ((adapter.getItem(position).getStoreName()).equals(lastOnClickStore2.getStoreName())){
                    lastOnClickStore2 = lastOnClickStore1;
                    lastOnClickStore1 = makeNewSearchStore(position);
                }
                else {
                    lastOnClickStore3 = lastOnClickStore2;
                    lastOnClickStore2 = lastOnClickStore1;
                    lastOnClickStore1 = makeNewSearchStore(position);
                }
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public Store makeNewSearchStore(int position){
        Store newStore = new Store (adapter.getItem(position).getIndex(), adapter.getItem(position).getImage(),
                adapter.getItem(position).getImage_b(),adapter.getItem(position).getImage_c(),
                adapter.getItem(position).getStoreName(),adapter.getItem(position).getLocation(),
                adapter.getItem(position).getCost(),adapter.getItem(position).getDescription());
        return newStore;
    }
}
