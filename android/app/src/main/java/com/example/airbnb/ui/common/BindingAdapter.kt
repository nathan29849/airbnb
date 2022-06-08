package com.example.airbnb.ui.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.api.load

@BindingAdapter("imageUrl")
fun setImage(view: ImageView, imageUrl: String) {
    view.load(imageUrl)
}

@BindingAdapter("distanceToText")
fun setDistanceToText(view: TextView, distance: String?) {
    if (!distance.isNullOrEmpty()) {
        val text = "차로 ${distance}분 거리"
        view.text = text
    }
}
