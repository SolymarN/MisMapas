package com.ivamadoka.mismapas;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double latitud;
    private Double longitud;
    private LatLng locationUser;
    private Marker mLocationUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle parametros = getIntent().getExtras();
        latitud =  parametros.getDouble(getResources().getString(R.string.latitud));
        longitud  =  parametros.getDouble(getResources().getString(R.string.longitud));

        Log.i("latitud", String.valueOf(latitud));
        Log.i("longitud", String.valueOf(longitud));

        locationUser = new LatLng(latitud,longitud);

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

       /* LatLng panama = new LatLng(9.04435621154599, -79.45394882015486);
        mMap.addMarker(new MarkerOptions().position(panama).title("Marker in Panama"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(panama));
*/

        mLocationUser = mMap.addMarker(new MarkerOptions()
                .position(locationUser)
                .title("Brisbane"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationUser));
        mLocationUser.setTag(0);


    }
}