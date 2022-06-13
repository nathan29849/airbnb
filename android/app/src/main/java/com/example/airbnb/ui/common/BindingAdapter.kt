package com.example.airbnb.ui.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.CircleCropTransformation
import com.example.airbnb.R
import java.text.DecimalFormat

@BindingAdapter("imageUrl")
fun setImage(view: ImageView, imageUrl: String?) {
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

@BindingAdapter("hostImage")
fun setHostImage(view: ImageView, imageUrl: String?) {
    view.load(imageUrl) {
        transformations(CircleCropTransformation())
    }
}

@BindingAdapter("maxNum")
fun setMaxNum(view: TextView, host: Int?) {
    if (host != null) {
        val text = "최대인원 ${host}명"
        view.text = text
    }
}

@BindingAdapter("room")
fun setRoom(view: TextView, room: Int?) {
    if (room != null) {
        val text = "방 ${room}개"
        view.text = text
    }
}

@BindingAdapter("bed")
fun setMBed(view: TextView, bed: Int?) {
    if (bed != null) {
        val text = "침대 ${bed}개"
        view.text = text
    }
}

@BindingAdapter("bath")
fun setBath(view: TextView, bath: Int?) {
    if (bath != null) {
        val text = "욕실 ${bath}개"
        view.text = text
    }
}
