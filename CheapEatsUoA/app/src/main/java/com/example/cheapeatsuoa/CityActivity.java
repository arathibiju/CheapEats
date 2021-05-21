package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cheapeatsuoa.Data.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CityActivity extends AppCompatActivity {
    class ViewHolder{
        ListView listViewStores;

        public ViewHolder(){
            listViewStores = findViewById(R.id.list_view_city);
        }
    }
    ViewHolder vh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        vh = new ViewHolder();

        Map<Integer, String>  wordsDict = DataProvider.generateCityStoreNames();
        List<String> stores = new ArrayList<>( wordsDict.values());
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                stores);
            ListView listView = (ListView) findViewById(R.id.list_view_city);
            listView.setAdapter(itemsAdapter);

    }


}