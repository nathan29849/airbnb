package com.example.airbnb

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ImageBitmap
import androidx.databinding.DataBindingUtil
import com.example.airbnb.data.model.Marker
import com.example.airbnb.databinding.ActivityMainBinding
import com.example.airbnb.databinding.ActivityMapBinding
import com.example.airbnb.ui.compose.CustomRoundButton
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
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
        listenBackButtonClick()
    }

    private fun listenBackButtonClick() {
        binding.btnBackToMenu.setOnClickListener {
            finish()
        }
    }

    private fun setMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val codeSquadLocation = LatLng(37.491, 127.0335)

        //addMyMarker(Marker(37.491, 127.0335, "₩201,599"))

        val coqure = mMap.addMarker(
            MarkerOptions()
                .position(codeSquadLocation)
                .title("₩201,599")
                .visible(true)
        )
        coqure?.showInfoWindow()
        coqure?.alpha = (0.0f)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(codeSquadLocation))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));
    }

    private fun addMyMarker(marker: Marker) {
        val markerView =
            LayoutInflater.from(this)
                .inflate(R.layout.custom_round_button, null)
//        val markerTextView = markerView.binding.tvCustomButtonText
//        markerTextView.text = "이히라"
        val markerOptions = MarkerOptions()
        markerOptions.position(LatLng(marker.lat, marker.lon))
        markerOptions.title(marker.price)
        markerOptions.icon(
            BitmapDescriptorFactory.fromResource(
                R.drawable.ic_baseline_menu_24
//                createDrawableFromView(
//                    this,
//                    markerView
//                )
            )
        )

        mMap.addMarker(markerOptions)
    }

    private fun createDrawableFromView(context: Context, view: View): Bitmap {
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.buildDrawingCache()
        val bitmap: Bitmap =
            Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = android.graphics.Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }
}