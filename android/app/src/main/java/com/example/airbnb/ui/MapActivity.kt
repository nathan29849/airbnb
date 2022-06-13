package com.example.airbnb.ui

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.airbnb.R
import com.example.airbnb.data.model.Marker
import com.example.airbnb.databinding.ActivityMapBinding
import com.example.airbnb.network.dto.Accommodation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.DecimalFormat

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapBinding
    private lateinit var mMap: GoogleMap
    private var accommodationList: List<Accommodation>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_map)
        accommodationList = intent.getParcelableArrayListExtra<Accommodation>("list")

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
        val formatter = DecimalFormat("#,###")

//        방법1. 구글 api 의 기능을 활용하여 기획서 대로 구현한 또 다른 방법
//        val coqure = mMap.addMarker(
//            MarkerOptions()
//                .position(codeSquadLocation)
//                .title("₩201,599")
//                .visible(true)
//        )
//        coqure?.showInfoWindow()
//        coqure?.alpha = (0.0f)ㄹ


        accommodationList?.forEach {
            // 방법2. View를 이미지화하여 구현한 방법(완전한 Custom이 가능함)
            addMyMarker(Marker(it.latitude, it.longitude, "₩" + formatter.format(it.price)))
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(codeSquadLocation))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));

    }

    private fun addMyMarker(marker: Marker) {

        val markerOptions = MarkerOptions().apply {
            position(LatLng(marker.lat, marker.lon))
            title(marker.price)
            icon(
                BitmapDescriptorFactory.fromBitmap(
                    createDrawableFromView(
                        marker.price
                    )
                )
            )
        }
        mMap.addMarker(markerOptions)
    }

    private fun createDrawableFromView(price: String): Bitmap {
        val markerContainer = LayoutInflater.from(this).inflate(R.layout.custom_marker, null);
        val markerTextView = markerContainer.findViewById<TextView>(R.id.tv_marker)
        markerTextView.text = price

        val displayMetrics = DisplayMetrics()

        markerContainer.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
        markerContainer.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)

        val bitmap =
            Bitmap.createBitmap(
                markerContainer.measuredWidth,
                markerContainer.measuredHeight,
                Bitmap.Config.ARGB_8888
            )
        val canvas = android.graphics.Canvas(bitmap)
        markerContainer.draw(canvas)

        return bitmap
    }
}
