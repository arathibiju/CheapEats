package com.example.cheapeatsuoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;

public class StoreDetailActivity extends AppCompatActivity {


    class ViewHolder{
        //example of how to use the view holder class
        TextView storeName;
        TextView storeLocation;
        TextView imageCount;
        ViewPager2 viewPager2;
        public ViewHolder(){
            imageCount = findViewById(R.id.image_count);
            viewPager2 = findViewById(R.id.view_pager);
            storeName = findViewById(R.id.detail_store_name);
            storeLocation = findViewById(R.id.detail_store_location);
        }
    }
    protected int[] currentImagesSet(Store currentStore){
        int[] imagesID = new int[3];

        imagesID[0] = this.getResources().getIdentifier(currentStore.getImage(), "drawable",
                    this.getPackageName());
        imagesID[1] = this.getResources().getIdentifier(currentStore.getImage_b(), "drawable",
                this.getPackageName());
        imagesID[2] = this.getResources().getIdentifier(currentStore.getImage_c(), "drawable",
                this.getPackageName());
        return imagesID;
    }

    ViewHolder vh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);
        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        vh = new StoreDetailActivity.ViewHolder();

        Intent receiveIntent = getIntent();
        Store detailActivityStore = receiveIntent.getParcelableExtra("FromActivity");

        vh.storeLocation.setText(detailActivityStore.getLocation());


        /*Intent sendCurrentStore = new Intent(this, MainActivity.class);
        sendCurrentStore.putExtra("FromDAct", detailActivityStore);
        startActivityForResult(sendCurrentStore, 1);
        */


        vh.storeName.setText(detailActivityStore.getStoreName());

        // Object of ViewPager2Adapter that passes the context to the constructor of
        // ViewPager2Adapter
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this, currentImagesSet(detailActivityStore));

        // adding the adapter to viewPager2 to show the views in recyclerview
        vh.viewPager2.setAdapter(viewPager2Adapter);

        vh.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            // This method is triggered when there is any scrolling activity for the current page
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            // triggered when you select a new page
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == 0){
                    vh.imageCount.setText("1/3");
                }else if (position == 1){
                    vh.imageCount.setText("2/3");
                } else{
                    vh.imageCount.setText("3/3");
                }

            }
            // triggered when there is
            // scroll state will be changed
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}