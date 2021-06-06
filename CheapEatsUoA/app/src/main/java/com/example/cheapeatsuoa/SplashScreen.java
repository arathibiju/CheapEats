package com.example.cheapeatsuoa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the status bar to a dark blue custom colour
        Window window = SplashScreen.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(SplashScreen.this, R.color.dark_blue_primary_dark));

        // set time for splashscreen to show on screen
        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        }, 1000);
    }
}