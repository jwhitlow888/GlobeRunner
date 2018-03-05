package com.app.globerunner.globerunner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

public class ProfileActivity extends AppCompatActivity {

    boolean loggedIn;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loggedIn = AccessToken.getCurrentAccessToken() != null;
        ProfilePictureView profilePicture = findViewById(R.id.profilePic);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Log.d("Is Logged in?", String.valueOf(loggedIn));
        if (loggedIn) {
            profilePicture.setProfileId(Profile.getCurrentProfile().getId());
        }
    }

    public void goToMap() {
        Intent myIntent = new Intent(ProfileActivity.this, MapActivity.class);
        startActivity(myIntent);
    }

}
