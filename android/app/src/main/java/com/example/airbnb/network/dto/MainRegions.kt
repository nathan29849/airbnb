package com.example.airbnb.network.dto

import com.google.gson.annotations.SerializedName

data class MainRegions(
    @SerializedName("regions")
    val regions: List<Region> = emptyList()
)

data class Region(
    @SerializedName("categoryId")
    val categoryId: Int = 0,
    @SerializedName("categoryName")
    val categoryName: String = "",
    @SerializedName("durationTime")
    val durationTime: Int = 0,
    @SerializedName("imageUrl")
    val imageUrl: String = ""
)