package com.example.airbnb.data.repository

import com.example.airbnb.network.RetrofitObject
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent
import javax.inject.Inject

class DataSourceImpl @Inject constructor() : DataSource {

    override suspend fun getMainEvent(): NetworkResponse<MainEvent> {
        return RetrofitObject.service.getMainEvent()
    }
}