package com.example.meteoritelandings

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.meteoritelandings.databinding.ActivityMapsBinding
import com.example.meteoritelandings.meteorits.JsonParser
import com.example.meteoritelandings.meteorits.Meteorit

@RequiresApi(Build.VERSION_CODES.O)
class MapsActivity : AppCompatActivity() {

    private val meteorits: List<Meteorit> by lazy {
        JsonParser(this).transform()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            addMarkers(googleMap) }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        meteorits.forEach { item ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(item.name)
                    .position(item.latLng)
            )
            marker?.tag = item
        }
    }
}