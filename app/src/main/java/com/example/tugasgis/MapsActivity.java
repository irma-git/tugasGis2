package com.example.tugasgis;

import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.tugasgis.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng untad = new LatLng(-0.83643, 119.89369);
        LatLng rsundatabaru = new LatLng(-0.858365, 119.883981);
        //Custom size marker
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable) getResources().getDrawable(R.drawable.pin_map_hitam);
        BitmapDrawable bitmapDes = (BitmapDrawable) getResources().getDrawable(R.drawable.pin_map_biru);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);
        //Add marker to map
        mMap.addMarker(new MarkerOptions().position(untad).title("Marker in Untad")
                .snippet("Ini adalah Kampus Kami")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));
        mMap.addMarker(new MarkerOptions().position(rsundatabaru).title("Marker in RS Undata Baru")
                .snippet("Ini adalah Rumah Sakit Undata Baru")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                untad,
                new LatLng(-0.836322, 119.892739),
                new LatLng(-0.836231, 119.889374),
                new LatLng(-0.836095, 119.885692),
                new LatLng(-0.836186, 119.883418),
                new LatLng(-0.842823, 119.883145),
                new LatLng(-0.846233, 119.882782),
                new LatLng(-0.848506, 119.882554),
                new LatLng(-0.855007, 119.883918),
                new LatLng(-0.855717, 119.883969),
                new LatLng(-0.857508, 119.883594),
                new LatLng(-0.858054, 119.883425),
                new LatLng(-0.858197, 119.883657),
                new LatLng(-0.858360, 119.883963),
                rsundatabaru
                ).width(10)
                        .color(Color.BLUE)
        );


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(untad, 11.5f));


    }
}
