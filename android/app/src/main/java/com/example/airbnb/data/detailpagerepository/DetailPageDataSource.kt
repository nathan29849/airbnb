package com.example.airbnb.data.detailpagerepository

import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.AccommodationDetailsResponse

interface DetailPageDataSource {

    suspend fun loadDetailPage(accommodationId: Int): NetworkResponse<AccommodationDetailsResponse>
}