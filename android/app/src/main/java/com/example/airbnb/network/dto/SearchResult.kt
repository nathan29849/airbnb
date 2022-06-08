package com.example.airbnb.network.dto


import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("data")
    val data: Data,
    @SerializedName("hasNext")
    val hasNext: Boolean
)

data class Data(
    @SerializedName("accommodations")
    val accommodations: List<Accommodation>,
    @SerializedName("total-count")
    val totalCount: Int
)

data class Accommodation(
    @SerializedName("accommodationId")
    val accommodationId: Int,
    @SerializedName("accommodationName")
    val accommodationName: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("like")
    val like: Boolean,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("mainImage")
    val mainImage: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("reviewCount")
    val reviewCount: Int,
    @SerializedName("starRating")
    val starRating: Double,
    @SerializedName("superHost")
    val superHost: Boolean,
    @SerializedName("totalPrice")
    val totalPrice: Int
)