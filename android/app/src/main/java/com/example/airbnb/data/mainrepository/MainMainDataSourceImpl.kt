package com.example.airbnb.data.mainrepository

import com.example.airbnb.network.RetrofitObject
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
        return RetrofitObject.service.getMainRegions(postLocation.longitude, postLocation.latitude)
    }
}