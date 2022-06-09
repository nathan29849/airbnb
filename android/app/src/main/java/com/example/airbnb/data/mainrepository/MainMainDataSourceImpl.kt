package com.example.airbnb.data.mainrepository

import com.example.airbnb.network.RetrofitObject
import com.example.airbnb.network.common.ErrorType
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent
import com.example.airbnb.network.dto.MainRegions
import com.example.airbnb.network.dto.PostLocation
import javax.inject.Inject

class MainMainDataSourceImpl @Inject constructor() : MainDataSource {

    override suspend fun getMainEvent(): NetworkResponse<MainEvent> {
        return RetrofitObject.service.getMainEvent()
    }

    override suspend fun getMainRegions(postLocation: PostLocation): NetworkResponse<MainRegions> {
        return if (postLocation.longitude != null && postLocation.latitude != null) {
            RetrofitObject.service.getMainRegions(postLocation.longitude, postLocation.latitude)
        } else {
            NetworkResponse.Error(ErrorType.NULL_BODY_ERROR, "위도 경도를 구할 수 없습니다.")
        }
    }
}