package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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

public class CityActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    int[] arr = {R.drawable.city_1, R.drawable.city_2,
            R.drawable.city_3, R.drawable.city_4,
            R.drawable.city_5, R.drawable.city_6,
            R.drawable.city_7, R.drawable.city_8,
            R.drawable.city_9, R.drawable.city_10};

/*
    class ViewHolder{
        //example of how to use the view holder class
        GridView gridViewStores; // create a view type

        public ViewHolder(){
            //gridViewStores = findViewById(R.id.grid_view_city); // instantiate it using id
        }
    }
    ViewHolder vh;
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager =  new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter =  new RecyclerViewAdapter(arr);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }


/*    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }*/


        // then we can use the view by going vh.gridViewStores
        //GridView gridView = findViewById(R.id.grid_view_city);

        //Intent receiveIntent = getIntent();
        //ArrayList<Store> cityStores = receiveIntent.getParcelableArrayListExtra("City");


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