package com.example.airbnb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.airbnb.databinding.ActivityMainBinding
import com.example.airbnb.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_map)
        setContentView(binding.root)

        setMapFragment()
    }

    private fun setMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val codeSquadLocation = LatLng(37.491, 127.0335)
        mMap.addMarker(
            MarkerOptions()
                .position(codeSquadLocation)
                .title("₩201,599")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(codeSquadLocation))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));
    }
}