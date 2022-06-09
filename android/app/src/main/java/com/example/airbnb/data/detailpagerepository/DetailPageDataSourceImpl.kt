package com.example.airbnb.data.detailpagerepository

import com.example.airbnb.network.RetrofitObject
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.AccommodationDetailsResponse
import javax.inject.Inject

class DetailPageDataSourceImpl @Inject constructor(): DetailPageDataSource {

    override suspend fun loadDetailPage(accommodationId: Int): NetworkResponse<AccommodationDetailsResponse> {
        return RetrofitObject.service.getDetailPage(accommodationId)
    }
}