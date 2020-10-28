package com.brewingjava.categoriesinfinity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signUpToMain(View view){
        EditText username = (EditText) findViewById(R.id.usernameText);
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
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                //tell user passwords must match
                passwordVerify.setText("");
                passwordVerify.setHint("Passwords must match");
            }
        }
        //TODO add else statement
    }

    //Would be for cancel button if added again
    /*public void backToLogin(View view){
        View signup = findViewById(R.id.signUpView);
        ((ViewGroup)signup.getParent()).removeView(signup);
    }*/
}
