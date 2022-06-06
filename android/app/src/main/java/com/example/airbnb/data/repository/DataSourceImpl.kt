package com.example.airbnb.data.repository

import android.util.Log
import com.example.airbnb.network.RetrofitObject
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent
import com.example.airbnb.network.dto.MainRegions
import com.example.airbnb.network.dto.PostLocation
import javax.inject.Inject

class DataSourceImpl @Inject constructor() : DataSource {

    override suspend fun getMainEvent(): NetworkResponse<MainEvent> {
        return RetrofitObject.service.getMainEvent()
    }

    override suspend fun getMainRegions(postLocation: PostLocation): NetworkResponse<MainRegions> {
        Log.d("위도경도", postLocation.longitude.toString())
        Log.d("위도경도", postLocation.latitude.toString())
        return RetrofitObject.service.getMainRegions(postLocation.longitude, postLocation.latitude)
    }
}