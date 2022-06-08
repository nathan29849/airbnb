package com.example.airbnb

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.airbnb.data.model.Marker
import com.example.airbnb.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapBinding

    private lateinit var mMap: GoogleMap
    lateinit var markerContainer: View
    lateinit var markerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_map)
        setContentView(binding.root)
        setCustomMarkerView()
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

    private fun setCustomMarkerView() {
        markerContainer = LayoutInflater.from(this).inflate(R.layout.custom_marker, null);
        markerTextView = markerContainer.findViewById<TextView>(R.id.tv_marker)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val codeSquadLocation = LatLng(37.491, 127.0335)

//        방법1. 구글 api 의 기능을 활용하여 기획서 대로 구현한 또 다른 방법
//        val coqure = mMap.addMarker(
//            MarkerOptions()
//                .position(codeSquadLocation)
//                .title("₩201,599")
//                .visible(true)
//        )
//        coqure?.showInfoWindow()
//        coqure?.alpha = (0.0f)

        // 방법2. View를 이미지화하여 구현한 방법(완전한 Custom이 가능함)
        addMyMarker(Marker(37.491, 127.0335, "₩201,599"))
        addMyMarker(Marker(37.501, 127.0362, "₩101,699"))
        addMyMarker(Marker(37.4612, 127.0513, "₩11,599"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(codeSquadLocation))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));
    }

    private fun addMyMarker(marker: Marker) {
        markerTextView.text = marker.price

        val markerOptions = MarkerOptions()
        markerOptions.position(LatLng(marker.lat, marker.lon))
        markerOptions.title(marker.price)

        markerOptions.icon(
            BitmapDescriptorFactory.fromBitmap(
                createDrawableFromView(
                    this,
                    markerContainer
                )
            )
        )
        mMap.addMarker(markerOptions)
    }

    private fun createDrawableFromView(context: Context, view: View): Bitmap {
        val displayMetrics = DisplayMetrics()
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
        val bitmap =
            Bitmap.createBitmap(
                view.measuredWidth,
                view.measuredHeight,
                Bitmap.Config.ARGB_8888
            )
        val canvas = android.graphics.Canvas(bitmap)
        view.draw(canvas)

        return bitmap
    }
}
