package com.example.cheapeatsuoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ListViewAdapter adapter;
    ArrayList<Store> offCampus = new ArrayList<>();

    class ViewHolder {
        SearchView searchView;
        ListView listView;

        public ViewHolder() {
            searchView = findViewById(R.id.search_view);
            listView = findViewById(R.id.list);
        }
    }
    ViewHolder vh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vh = new ViewHolder();

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        offCampus =  intent.getParcelableArrayListExtra("search");

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, offCampus);
        vh.listView.setAdapter(adapter);


        vh.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.filter(s);
                return false;
            }
        });

        setupStoreSelectedListener();
    }

    public void setupStoreSelectedListener() {
        vh.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(SearchActivity.this, StoreDetailActivity.class);
                intent.putExtra("FromActivity", adapter.getItem(position)); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
