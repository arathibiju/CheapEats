package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cheapeatsuoa.Data.DataProvider;
import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OffCampusActivity extends AppCompatActivity {
    class ViewHolder{
        ListView listViewStores;

        public ViewHolder(){
            listViewStores = findViewById(R.id.list_view_off_campus);
        }
    }
    OffCampusActivity.ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off_campus);

        vh = new OffCampusActivity.ViewHolder();

        Intent receiveIntent = getIntent();
        ArrayList<Store> offCampusStores = receiveIntent.getParcelableArrayListExtra("Off");

        Map<Integer, String> wordsDict = DataProvider.generateOffCampusStoreNames();
        List<String> stores = new ArrayList<String>( wordsDict.values());
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                stores);
        ListView listView = (ListView) findViewById(R.id.list_view_off_campus);
        listView.setAdapter(itemsAdapter);
    }
}