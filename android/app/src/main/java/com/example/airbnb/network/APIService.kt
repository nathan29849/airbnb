package com.example.airbnb.network

import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent
import com.example.airbnb.network.dto.MainRegions
import com.example.airbnb.network.dto.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("categories/events")
    suspend fun getMainEvent(): NetworkResponse<MainEvent>

    @GET("categories/regions")
    suspend fun getMainRegions(
        @Query("longitude") longitude: Double?,
        @Query("latitude") latitude: Double?
    ): NetworkResponse<MainRegions>

    @GET("accommodations")
    suspend fun getSearchResult(
        @Query("location") location: String,
        @Query("checkIn") checkIn: String,
        @Query("checkOut") checkOut: String,
        @Query("minPrice") minPrice: Int,
        @Query("maxPrice") maxPrice: Int,
        @Query("adult") adult: Int,
        @Query("child") child: Int,
        @Query("baby") baby: Int,
        @Query("page") page: Int,
        @Query("limit") limit: Int = 5
        ): SearchResult
}