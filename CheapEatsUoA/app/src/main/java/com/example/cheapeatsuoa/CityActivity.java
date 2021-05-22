package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cheapeatsuoa.Data.DataProvider;
import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class CityActivity extends AppCompatActivity {
    /*class ViewHolder{
        ListView listViewStores;

        public ViewHolder(){
            listViewStores = findViewById(R.id.list_view_city);
        }
    }
    ViewHolder vh;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        GridView gridView = (GridView) findViewById(R.id.grid_view_city);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new Store(this));

        //vh = new ViewHolder();

/*        Map<Integer, String>  wordsDict = DataProvider.generateCityStoreNames();
        List<String> stores = new ArrayList<>( wordsDict.values());
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                stores);
            ListView listView = (ListView) findViewById(R.id.list_view_city);
            listView.setAdapter(itemsAdapter);*/

    }


}