package com.example.airbnb.data.model

import android.os.Parcelable
import com.example.airbnb.ui.common.PRICE_MAX_VALUE
import com.example.airbnb.ui.common.TEN_MAAN
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchCondition(
    val location: String? = "회기",
    var checkIn: String? = null,
    var checkOut: String? = null,
    var minPrice: Int = 0,
    var maxPrice: Int = TEN_MAAN * PRICE_MAX_VALUE,
    var adult: Int = 0,
    var child: Int = 0,
    var baby: Int = 0,
) : Parcelable
