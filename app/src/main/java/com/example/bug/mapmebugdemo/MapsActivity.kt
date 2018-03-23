package com.example.bug.mapmebugdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import nz.co.trademe.mapme.LatLng

class MapsActivity() : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val locationsList = mutableListOf(LatLng(0.0,0.0))
    private lateinit var mapAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mapAdapter = MyAdapter(this, locationsList)
        mapAdapter.attach(this.findViewById(android.R.id.content), mMap)
        mapAdapter.notifyDataSetChanged()
        // Delete the following line to prevent the crash.
        mapAdapter.notifyDataSetChanged()
    }
}
