package com.example.airbnb.data.mainrepository

import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent
import com.example.airbnb.network.dto.MainRegions
import com.example.airbnb.network.dto.PostLocation
import javax.inject.Inject

class MainRepository @Inject constructor(private val mainDataSource: MainDataSource){

    suspend fun getMainEvent(): NetworkResponse<MainEvent> {
        return mainDataSource.getMainEvent()
    }

    suspend fun getMainRegions(postLocation: PostLocation): NetworkResponse<MainRegions> {
        return mainDataSource.getMainRegions(postLocation)
    }
}