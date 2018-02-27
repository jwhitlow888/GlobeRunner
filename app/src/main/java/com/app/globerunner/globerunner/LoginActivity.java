package com.app.globerunner.globerunner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Jacob Whitlow, Kavin Sivakumar, and Leif Grosswiler on 2/27/18.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToProfile(View v) {
        Log.d("DEBUGGING", "We HERREEEE");
        Intent myIntent = new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(myIntent);
    }

}
