package com.example.airbnb.data.model

data class SearchCondition(
    val location: String? = "회기",
    var checkIn: String? = null,
    var checkOut: String? = null,
    var minPrice: Int? = null,
    var maxPrice: Int? = null,
    var adult: Int? = null,
    var child: Int? = null,
    var baby: Int? = null,
)
