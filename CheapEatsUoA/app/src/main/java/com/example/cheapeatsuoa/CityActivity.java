package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
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

    Intent receiveIntent = getIntent();
    //ArrayList<Store> cityStores = receiveIntent.getParcelableArrayListExtra("City");
    ArrayList<Store> cityStores = DataProvider.getCityStores();

    /* we can then use cityStores list to populate the recycler view first. like maybe use a
         loop to go through the list then do the getStoreName method for each to get the list of names.
         At least i think this is how it is. feel free to make any changes btw, idk if any of this is
         like good coding practice*/
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        Window window = CityActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(CityActivity.this, R.color.dark_blue_primary_dark));

        recyclerView = findViewById(R.id.city_recycler_view);
        layoutManager =  new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter =  new RecyclerViewAdapter(this, R.layout.activity_city, cityStores);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }}


/*    int[] arr = {R.drawable.city_1, R.drawable.city_2,
            R.drawable.city_3, R.drawable.city_4,
            R.drawable.city_5, R.drawable.city_6,
            R.drawable.city_7, R.drawable.city_8,
            R.drawable.city_9, R.drawable.city_10};*/





