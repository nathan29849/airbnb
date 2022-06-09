package com.example.airbnb.data.detailpagerepository

import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.AccommodationDetailsResponse
import javax.inject.Inject

class DetailPageRepository @Inject constructor(private val detailPageDataSource: DetailPageDataSource) {

    suspend fun loadDetailPage(accommodationId: Int): NetworkResponse<AccommodationDetailsResponse> {
        return detailPageDataSource.loadDetailPage(accommodationId)
    }
}