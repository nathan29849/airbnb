package com.example.airbnb.network

import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent
import com.example.airbnb.network.dto.MainRegions
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("categories/events")
    suspend fun getMainEvent(): NetworkResponse<MainEvent>

    @GET("categories/regions")
    suspend fun getMainRegions(
        @Query("longitude") longitude: Double,
        @Query("latitude") latitude: Double
    ): NetworkResponse<MainRegions>
}