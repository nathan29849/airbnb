package com.example.airbnb.network

import com.example.airbnb.network.dto.SearchContents
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("categories")
    suspend fun getSearchContents(): Response<SearchContents>
}