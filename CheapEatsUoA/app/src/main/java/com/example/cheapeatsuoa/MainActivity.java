package com.example.cheapeatsuoa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    class ViewHolder{
        CardView cityCardView;

        public ViewHolder() {
            cityCardView =  findViewById(R.id.card_view_city);
        }
    }


    ViewHolder vh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vh = new ViewHolder();
        vh.cityCardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent cityCampusActivity = new Intent(getBaseContext(),CityActivity.class);
                cityCampusActivity.putExtra("FromMainActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                startActivity(cityCampusActivity);
            }
        });

    }
}