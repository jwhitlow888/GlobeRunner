package com.app.globerunner.globerunner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

/**
 * Created by Jacob Whitlow, Alex Byrnes, John Van Orden and Bertha Wang on 2/27/18.
 */

public class LoginActivity extends FragmentActivity {

    CallbackManager callbackManager;
    boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loggedIn = AccessToken.getCurrentAccessToken() != null;
        if (loggedIn)
            goToProfile();

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("FB Login", "Success!");
                        // App code
                    }

                    @Override
                    public void onCancel() {
                        Log.d("FB Login", "Canceled!");
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.d("FB Login", exception.toString());
                        // App code
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        goToProfile();
    }

    public void goToProfile() {
        Intent myIntent = new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(myIntent);
    }

}
