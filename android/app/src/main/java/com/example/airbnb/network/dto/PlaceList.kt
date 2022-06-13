package com.example.airbnb.network.dto


import com.google.gson.annotations.SerializedName

data class PlaceList(
    @SerializedName("keywords")
    val keywords: List<String>
)