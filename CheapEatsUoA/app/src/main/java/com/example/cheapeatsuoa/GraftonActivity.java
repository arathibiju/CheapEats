package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cheapeatsuoa.Data.DataProvider;
import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraftonActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Store> graftonStores = DataProvider.getGraftonStores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafton);
        recyclerView = findViewById(R.id.grafton_recycler_view);
        layoutManager =  new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter =  new RecyclerViewAdapter(this, R.layout.activity_grafton, graftonStores);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}



/*     class ViewHolder{
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

        Intent receiveIntent = getIntent();
        ArrayList<Store> graftonStores = receiveIntent.getParcelableArrayListExtra("Grafton");

        Map<Integer, String> wordsDict = DataProvider.generateGraftonStoreNames();
        List<String> stores = new ArrayList<String>( wordsDict.values());
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                stores);
        ListView listView = (ListView) findViewById(R.id.list_view_grafton);
        listView.setAdapter(itemsAdapter);
    }*/