package com.example.airbnb.data.mainrepository

import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent
import com.example.airbnb.network.dto.MainRegions
import com.example.airbnb.network.dto.PlaceList
import com.example.airbnb.network.dto.PostLocation

interface MainDataSource {

    suspend fun getMainEvent(): NetworkResponse<MainEvent>

    suspend fun getMainRegions(postLocation: PostLocation): NetworkResponse<MainRegions>

    suspend fun getPlaceList(keyword: String): NetworkResponse<PlaceList>
}