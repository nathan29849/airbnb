package com.example.airbnb.network.dto


import com.google.gson.annotations.SerializedName

data class SearchContents(
    @SerializedName("events")
    val events: List<Event?>,
    @SerializedName("regions")
    val regions: List<Region?>
)

data class Region(
    @SerializedName("categoryId")
    val categoryId: Int?,
    @SerializedName("categoryName")
    val categoryName: String?,
    @SerializedName("distance")
    val distance: Int?,
    @SerializedName("mainImage")
    val mainImage: String?
)

data class Event(
    @SerializedName("categoryId")
    val categoryId: Int?,
    @SerializedName("categoryName")
    val categoryName: String?,
    @SerializedName("mainImage")
    val mainImage: String?
)