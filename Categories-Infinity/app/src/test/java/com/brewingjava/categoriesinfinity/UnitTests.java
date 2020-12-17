package com.brewingjava.categoriesinfinity;

import android.app.Activity;

import androidx.annotation.ContentView;

import com.brewingjava.categoriesinfinity.ui.login.LoginScreen;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTests {
    private Activity mActivity;

    SignUp signup = new SignUp();
    LoginScreen loginScreen = new LoginScreen();
    MainActivity mainActivity = new MainActivity();

    @Test
    public void loginWithoutCredentials(){
        String username = "";
        String password = "";

    }
}
