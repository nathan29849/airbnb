package com.example.airbnb.network.dto


import com.google.gson.annotations.SerializedName

data class SearchContents(
    @SerializedName("data")
    val data: Data?
)

data class Data(
    @SerializedName("event")
    val event: List<Event?>,
    @SerializedName("region")
    val region: List<Region?>
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