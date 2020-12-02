package com.brewingjava.categoriesinfinity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }

    public void signUpToMain(View view){
        final EditText username = (EditText) findViewById(R.id.usernameText);
        EditText password = (EditText) findViewById(R.id.passwordTextEnter);
        EditText passwordVerify = (EditText) findViewById(R.id.passwordTextVerify);

        Pattern letters = Pattern.compile("[a-zA-Z]");
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern numbers = Pattern.compile("[0-9]");
        Pattern specialCharacters = Pattern.compile("[^a-zA-Z0-9]");

        Matcher matchLetter = letters.matcher(password.getText().toString());
        Matcher matchUppercase = uppercase.matcher((password.getText().toString()));
        Matcher matchNumber = numbers.matcher(password.getText().toString());
        Matcher matchSpecialCharacter = specialCharacters.matcher(password.getText().toString());

        boolean containsLetter = matchLetter.find();
        boolean containsUppercase = matchUppercase.find();
        boolean containsNumber = matchNumber.find();
        boolean containsSpecialCharacter = matchSpecialCharacter.find();

        //Verify password
        if(password.getText().toString().length() >= 8 && containsLetter && containsNumber
                && containsSpecialCharacter && containsUppercase &&
                username.getText().toString().length() > 0){
            if(password.getText().toString().equals(passwordVerify.getText().toString())){
                //send to home screen
                String emailUsername = username.getText().toString() + "@categoriesinfinity.com";
                //Taken from https://firebase.google.com/docs/auth/android/password-auth
                mAuth.createUserWithEmailAndPassword(emailUsername, password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("UsernamePassword", "createUserWithEmail:success");

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                    mDatabase = FirebaseDatabase.getInstance().getReference();
                                    mDatabase.child("users").child(userId).child("username").setValue(username.getText().toString());
                                    mDatabase.child("users").child(userId).child("gamesPlayed").setValue(0);

                                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                    //updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("UsernamePassword", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUp.this, "Authentication failed. Choose different username",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }

                                // ...
                            }
                        });
            }else{
                //tell user passwords must match
                //TODO add more descriptive errors
                Toast.makeText(SignUp.this, "Passwords must match",
                        Toast.LENGTH_SHORT).show();
            }

        }else{
            if(username.getText().length() == 0){
                Toast.makeText(SignUp.this, "Username must be at least 1 character",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(SignUp.this, "Password must contain 1 uppercase, 1 letter, 1 number and 1 special character",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Cancel button
    public void backToLogin(View view){
        finish();
    }
}
