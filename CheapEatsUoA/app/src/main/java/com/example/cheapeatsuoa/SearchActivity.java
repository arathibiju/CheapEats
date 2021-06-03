package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.MenuItemCompat;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        vh = new ViewHolder();

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        offCampus =  intent.getParcelableArrayListExtra("search");

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, offCampus);
        vh.listView.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        vh.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                String text = s;
                adapter.filter(text);
                return false;
            }
        });
       /* if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            searchStores(query);
        }*/



    }



    private void searchStores(String query) {
    }

}
