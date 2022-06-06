package com.example.airbnb.network.dto

import com.google.gson.annotations.SerializedName

data class MainEvent(
    @SerializedName("events")
    val events: List<Event> = emptyList()
)

data class Event(
    @SerializedName("categoryId")
    val categoryId: Int = 0,
    @SerializedName("categoryName")
    val categoryName: String = "",
    @SerializedName("mainImage")
    val mainImage: String = ""
)