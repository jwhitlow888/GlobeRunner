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
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

public class ProfileActivity extends AppCompatActivity {

    boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loggedIn = AccessToken.getCurrentAccessToken() != null;
        ProfilePictureView profilePicture = findViewById(R.id.profilePic);
        TextView profName = findViewById(R.id.profName);
        if (loggedIn && Profile.getCurrentProfile() != null) {
            profilePicture.setProfileId(Profile.getCurrentProfile().getId());
            String name = Profile.getCurrentProfile().getFirstName() + " " + Profile.getCurrentProfile().getLastName();
            profName.setText(name);
        }
    }

}
