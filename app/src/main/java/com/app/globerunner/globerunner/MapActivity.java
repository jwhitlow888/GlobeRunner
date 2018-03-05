package com.app.globerunner.globerunner;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Jacob Whitlow, Alex Byrnes, John Van Orden and Bertha Wang on 3/3/18.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback{

    MapFrag frag;

    @Override
    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_map);
        frag = MapFrag.newInstance();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        frag.onMapReady(googleMap);
    }

}
