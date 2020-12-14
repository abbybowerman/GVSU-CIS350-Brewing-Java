package com.brewingjava.categoriesinfinity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Secrets s = new Secrets();

        // Initialize the SDK
        Places.initialize(getApplicationContext(), s.apikey);
        // Create a new PlacesClient instance
        PlacesClient placesClient = Places.createClient(this);
    }
}
