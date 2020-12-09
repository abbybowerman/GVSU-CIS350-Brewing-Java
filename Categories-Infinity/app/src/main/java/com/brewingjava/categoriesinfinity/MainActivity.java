package com.brewingjava.categoriesinfinity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    private static ArrayList<String> usernames = new ArrayList<String>();

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
        TextView numGames = findViewById(R.id.numGames);

        numGamesPlayedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int numGames = 0;
                numGames = dataSnapshot.getValue(Integer.class);

                //This print statement is here for testing
                //TODO add to number of games played text view
                String strNum = Integer.toString(numGames);
                TextView numGamesL = findViewById(R.id.numGames);
                numGamesL.setText(strNum);
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
                System.out.println(usernames);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        final Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                EditText userField = findViewById(R.id.usernameText);
                TextView result = findViewById(R.id.searchResult);
                if(userField.getText().toString().length() != 0){
                    if(search(usernames, userField.getText().toString())){
                        result.setText(userField.getText().toString() + " has been found");
                    }else{
                        result.setText(userField.getText().toString() + " has not been found");
                    }
                }else{
                    result.setText("Please enter a valid username to search");
                }
            }
        });
        

    }

    public void clearResult(View view){
        TextView result = findViewById(R.id.searchResult);
        result.setText("");
    }

    public boolean search(ArrayList<String> arr, String enteredUser){
        for(String user : arr){
            if(enteredUser.equals(user)){
                return true;
            }
        }
        return false;
    }

    public void profilePage(View view) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void gamePlay(View view) {
        //Get current user
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //Increment game counter
        TextView numGames = findViewById(R.id.numGames);
        int num = Integer.parseInt(numGames.getText().toString());
        num++;
        mDatabase.child("users").child(userId).child("gamesPlayed").setValue(num);

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