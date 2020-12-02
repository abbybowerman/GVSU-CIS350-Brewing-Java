package com.brewingjava.categoriesinfinity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View view;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //This was largely taken/adapted from a StackOverflow post on 12/2/2020
        //https://stackoverflow.com/questions/54244973/getting-data-from-firebase-realtime-database-android-studio-java
        DatabaseReference numGamesPlayedRef = mDatabase.child("users").child(userId).child("gamesPlayed");
        DatabaseReference usernamesRef = mDatabase.child("users");
        //final String[] numGames = {"0"};
        final ArrayList<String> usernames = new ArrayList<String>();

        numGamesPlayedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int numGames = 0;
                numGames = dataSnapshot.getValue(Integer.class);

                //This print statement is here for testing
                //TODO add to number of games played text view
                System.out.println(numGames);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        usernamesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    DataSnapshot g = ds.child("username");
                    String username = g.getValue(String.class);
                    usernames.add(username);
                }

                //This print statement is here for testing
                //TODO integrate in with search function
                System.out.println(usernames);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

    }

    public void profilePage(View view) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void gamePlay(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
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