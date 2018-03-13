package com.app.globerunner.globerunner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

/**
 * Created by Jacob Whitlow, Alex Byrnes, John Van Orden and Bertha Wang on 3/6/18.
 */

public class MainActivity extends AppCompatActivity {

    boolean loggedIn;

    private View.OnClickListener mOnViewListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToProfile();
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.photos:
                    return true;
                case R.id.trophies:
                    return true;
                case R.id.map:
                    goToMap();
                    return true;
            }
            return false;
        }
    };

    public void goToProfile() {
        Intent myIntent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(myIntent);
    }

    public void goToMap() {
        Intent myIntent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loggedIn = AccessToken.getCurrentAccessToken() != null;
        ProfilePictureView profilePicture = findViewById(R.id.cornerProfilePic);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        profilePicture.setOnClickListener(mOnViewListener);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Log.d("Is Logged in?", String.valueOf(loggedIn));
        try {
            while (Profile.getCurrentProfile() == null) wait((long)100);
        }
        catch (Exception e) {
            Log.d("Interruption", e.toString());
        }
        if (loggedIn && Profile.getCurrentProfile() != null) {
            profilePicture.setProfileId(Profile.getCurrentProfile().getId());
        }
    }

}
