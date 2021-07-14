package com.example.cheapeatsuoa.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import com.example.cheapeatsuoa.Model.Store;
import com.example.cheapeatsuoa.R;
import com.example.cheapeatsuoa.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;


public class GraftonActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Store> graftonStores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafton);

        //set the status bar to a dark blue custom colour
        Window window = GraftonActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(GraftonActivity.this, R.color.dark_blue_primary_dark));

        Intent receiveIntent = getIntent();
        graftonStores = receiveIntent.getParcelableArrayListExtra("Grafton");

        RecyclerView recyclerView = findViewById(R.id.grafton_recycler_view);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            layoutManager =  new GridLayoutManager(this, 2);
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            layoutManager =  new GridLayoutManager(this, 4);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter =  new RecyclerViewAdapter(this, R.layout.activity_grafton, graftonStores, "GraftonActivity");
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