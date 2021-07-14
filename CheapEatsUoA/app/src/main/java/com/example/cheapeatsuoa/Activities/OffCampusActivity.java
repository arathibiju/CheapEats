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


public class OffCampusActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Store> offCampusStores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off_campus);

        //set the status bar to a dark blue custom colour
        Window window = OffCampusActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(OffCampusActivity.this, R.color.dark_blue_primary_dark));

        Intent receiveIntent = getIntent();
        offCampusStores = receiveIntent.getParcelableArrayListExtra("Off");

        RecyclerView recyclerView = findViewById(R.id.off_campus_recycler_view);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            layoutManager =  new GridLayoutManager(this, 2);
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            layoutManager =  new GridLayoutManager(this, 4);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter =  new RecyclerViewAdapter(this, R.layout.activity_off_campus, offCampusStores, "OffCampusActivity");
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
