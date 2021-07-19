package com.example.cheapeatsuoa.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cheapeatsuoa.Adapters.ViewPager2Adapter;
import com.example.cheapeatsuoa.Fragments.CustomMapFragment;
import com.example.cheapeatsuoa.Model.Store;
import com.example.cheapeatsuoa.R;
import com.example.cheapeatsuoa.SplashScreen;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class StoreDetailActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnPoiClickListener {

    String activity;

    class ViewHolder{
        //View holder class to store views used in layout
        TextView storeName;
        TextView storeLocation;
        TextView imageCount;
        TextView description;
        TextView cost;
        ViewPager2 viewPager2;
        TextView campusText;
        ImageView leftArrow;
        ImageView rightArrow;
        ImageView mapIcon;
        Button mapButton;
        ScrollView scrollView;

        public ViewHolder(){
            //instantiate views
            imageCount = findViewById(R.id.image_count);
            viewPager2 = findViewById(R.id.view_pager);
            storeName = findViewById(R.id.detail_store_name);
            storeLocation = findViewById(R.id.detail_store_location);
            description = findViewById(R.id.general_food_type);
            cost = findViewById(R.id.detail_store_cost);
            campusText = findViewById(R.id.general_location);
            leftArrow = findViewById(R.id.image_slider_left_arrow);
            rightArrow = findViewById(R.id.image_slider_right_arrow);
            mapIcon = findViewById(R.id.location_icon);
            mapButton = findViewById(R.id.mapButton);
            scrollView = findViewById(R.id.content);
        }
    }

    //Get the resource values needed for the images to be displayed in the current viewpager based on
    // the store fields.
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

        // Set the status bar colour to dark blue.
        Window window = StoreDetailActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(StoreDetailActivity.this, R.color.dark_blue_primary_dark));

        //Add custom toolbar to app layout
        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        // create new view holder instance
        vh = new StoreDetailActivity.ViewHolder();

        // Get a handle to the fragment and register the callback.
        SupportMapFragment mapFragment = (CustomMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
            mapFragment.requireView().setVisibility(View.GONE);
        }


        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        ViewGroup.LayoutParams params = null;
        if (mapFragment != null) {
            params = mapFragment.requireView().getLayoutParams();
        }
        Objects.requireNonNull(params).height = height/3;
        mapFragment.requireView().setLayoutParams(params);

        // Receive intent from previous activity that contains store model that was clicked on as well as
        // the name of previous activity
        Intent receiveIntent = getIntent();
        Store detailActivityStore = receiveIntent.getParcelableExtra("FromActivity");
        activity = receiveIntent.getExtras().getString("recycleView");

        //set the text views in the details activity
        vh.storeLocation.setText(detailActivityStore.getLocation());
        vh.storeName.setText(detailActivityStore.getStoreName());
        vh.description.setText(detailActivityStore.getDescription());
        vh.cost.setText(detailActivityStore.getCost());

        //Get the category of the store based on the image file names
        String campus = detailActivityStore.getImage();

        if(campus.contains("city")){
            vh.campusText.setText("City Campus");
        } else if (campus.contains("grafton")){
            vh.campusText.setText("Grafton Campus");
        } else{
            vh.campusText.setText("Off Campus");
        }

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

        // Add on click handlers for the image navigation buttons in the detail view

        // check is requested image out of bounds and if not then provide image
        vh.leftArrow.setOnClickListener(v -> {
            if (vh.viewPager2.getCurrentItem() != 0){
                vh.viewPager2.setCurrentItem(vh.viewPager2.getCurrentItem() - 1, true);
            }

        });
        // check is requested image out of bounds and if not then provide image
        vh.rightArrow.setOnClickListener(v -> {
            if (vh.viewPager2.getCurrentItem() != 2){
                vh.viewPager2.setCurrentItem(vh.viewPager2.getCurrentItem() + 1, true);
            }
        });

        // Enable map on button click
        vh.mapButton.setOnClickListener(v -> {

            if (!mapFragment.isVisible()) {
                mapFragment.requireView().setVisibility(View.VISIBLE);
                new Handler().postDelayed(() -> {
                    // This method will be executed once the timer is over
                    vh.scrollView.fullScroll(View.FOCUS_DOWN);
                }, 500);
            } else {
                mapFragment.requireView().setVisibility(View.GONE);
            }


        });

        /*vh.mapIcon.setOnClickListener(v -> {
        //https://www.google.com/maps/search/?api=1&query=Munchy+mart+Symonds+Street%2C+Auckland+CBD%2C+Auckland
            // geo:0,0?q=
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Munchy+mart+Symonds+Street%2C+Auckland+CBD%2C+Auckland");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        });*/
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        ScrollView ScrollView = findViewById(R.id.content); //parent scrollview in xml, give your scrollview id value
        ((CustomMapFragment) Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.map)))
                .setListener(() -> ScrollView.requestDisallowInterceptTouchEvent(true));
        LatLng sydney = new LatLng(-36.852134, 174.768336);

        googleMap.addMarker(new MarkerOptions().position(sydney).title("Munchy Mart"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));

    }


    @Override
    public void onPoiClick(PointOfInterest poi) {
        Toast.makeText(this, "Clicked: " +
                        poi.name + "\nPlace ID:" + poi.placeId +
                        "\nLatitude:" + poi.latLng.latitude +
                        " Longitude:" + poi.latLng.longitude,
                Toast.LENGTH_SHORT).show();

    }

    /*The next two functions help us refresh the main activity when we return to it directly from
    detail view. For example if an item from the top picks panel was selected, then we use the back
    button to return to the main activity. We need to refresh the main activity so that the top picks
    panel will update */

    public void onBackPressed() {
        //check if we actually came from main activity, otherwise the back button from details activity
        // will take us directly back to main regardless of the previous activity

      if (activity!= null){
          if (activity.contains("Main")){
              Intent intent = new Intent(this, MainActivity.class);
              startActivity(intent);
              finish();
              overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
          }
      }
        super.onBackPressed();

    }

    // Custom transitions in and out of this activity
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}