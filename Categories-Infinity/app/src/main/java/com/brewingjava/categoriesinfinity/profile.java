package com.brewingjava.categoriesinfinity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void signUpToMain(View view){
        //send to profile
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

//    Toolbar toolbar = findViewById(R.id.toolbar);
//    setSupportActionBar(toolbar);
//    FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener(){
//        @Override
//        public void onClick(View view) {
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();
//        }
//    });
}
