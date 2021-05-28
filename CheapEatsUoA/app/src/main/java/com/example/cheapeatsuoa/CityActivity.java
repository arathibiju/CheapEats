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
    class ViewHolder{
        //example of how to use the view holder class
        GridView gridViewStores; // create a view type

        public ViewHolder(){
            gridViewStores = findViewById(R.id.grid_view_city); // instantiate it using id
        }
    }
    ViewHolder vh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        vh = new ViewHolder();

        // then we can use the view by going vh.gridViewStores
        GridView gridView = findViewById(R.id.grid_view_city);

        Intent receiveIntent = getIntent();
        ArrayList<Store> cityStores = receiveIntent.getParcelableArrayListExtra("City");
        /* we can then use cityStores list to populate the recycler view first. like maybe use a
         loop to go through the list then do the getStoreName method for each to get the list of names.
         At least i think this is how it is. feel free to make any changes btw, idk if any of this is
         like good coding practice*/








        // Instance of ImageAdapter Class
       // gridView.setAdapter(new Store(this));

        //

/*        Map<Integer, String>  wordsDict = DataProvider.generateCityStoreNames();
        List<String> stores = new ArrayList<>( wordsDict.values());
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                stores);
            ListView listView = (ListView) findViewById(R.id.list_view_city);
            listView.setAdapter(itemsAdapter);*/

    }


}