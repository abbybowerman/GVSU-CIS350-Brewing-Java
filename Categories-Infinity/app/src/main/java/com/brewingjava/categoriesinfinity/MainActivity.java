package com.brewingjava.categoriesinfinity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.brewingjava.categoriesinfinity.GameActivity;
import com.brewingjava.categoriesinfinity.ProfileActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private View view;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void profilePage(View view) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void gamePlay(View view) {
        Intent intent2 = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent2);
    }

    /** Displays menu for logout button */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if(item.getItemId() == R.id.logoutButton){
            //Logout user
            FirebaseAuth.getInstance().signOut();
            //Close main screen
            finish();
        }
        return true;
    }

    /** Disables back button */
    @Override
    public void onBackPressed() {

    }
}