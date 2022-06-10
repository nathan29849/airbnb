package com.example.airbnb.ui.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.example.airbnb.R
import java.text.DecimalFormat

@BindingAdapter("imageUrl")
fun setImage(view: ImageView, imageUrl: String) {
    view.load(imageUrl)
}

@BindingAdapter("distanceToText")
fun setDistanceToText(view: TextView, distance: Int?) {
    if (distance != null) {
        val text = "차로 ${distance / 60}시간 거리"
        view.text = text
    }
}

@BindingAdapter("priceAmountPerDay")
fun applyPriceFormatPerDay(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(R.string.unit_discount_currency_per_day, decimalFormat.format(price))
}

@BindingAdapter("priceAmountTotal")
fun applyPriceFormatTotal(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(R.string.unit_discount_currency_total, decimalFormat.format(price))
}

@BindingAdapter("hostName")
fun setHostName(view: TextView, host: String?) {
    if (!host.isNullOrEmpty()) {
        val text = "호스트: ${host}님"
        view.text = text
    }
}
