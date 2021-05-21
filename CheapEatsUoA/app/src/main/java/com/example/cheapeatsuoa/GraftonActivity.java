package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cheapeatsuoa.Data.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraftonActivity extends AppCompatActivity {
    class ViewHolder{
        ListView listViewStores;

        public ViewHolder(){
            listViewStores = findViewById(R.id.list_view_grafton);
        }
    }
    GraftonActivity.ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafton);

        vh = new GraftonActivity.ViewHolder();

        Map<Integer, String> wordsDict = DataProvider.generateGraftonStoreNames();
        List<String> stores = new ArrayList<String>( wordsDict.values());
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                stores);
        ListView listView = (ListView) findViewById(R.id.list_view_grafton);
        listView.setAdapter(itemsAdapter);
    }
}