package com.example.airbnb.network

import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent
import retrofit2.http.GET

interface APIService {

    @GET("categories/events")
    suspend fun getMainEvent(): NetworkResponse<MainEvent>
}