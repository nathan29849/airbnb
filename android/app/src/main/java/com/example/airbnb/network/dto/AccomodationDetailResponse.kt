package com.example.airbnb.network.dto


import com.google.gson.annotations.SerializedName

data class AccommodationDetailsResponse(
    @SerializedName("accommodationDetails")
    val accommodationDetails: AccommodationDetails,
    @SerializedName("accommodationId")
    val accommodationId: Int?,
    @SerializedName("hostImage")
    val hostImage: String?,
    @SerializedName("hostName")
    val hostName: String?,
    @SerializedName("images")
    val images: List<String>?,
    @SerializedName("like")
    val like: Boolean?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("starRating")
    val starRating: Double?
)

data class AccommodationDetails(
    @SerializedName("bathroomCount")
    val bathroomCount: Int?,
    @SerializedName("bedCount")
    val bedCount: Int?,
    @SerializedName("maximumGuestNumber")
    val maximumGuestNumber: Int?,
    @SerializedName("roomCount")
    val roomCount: Int?
)