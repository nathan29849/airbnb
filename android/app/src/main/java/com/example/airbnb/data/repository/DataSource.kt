package com.example.airbnb.data.repository

import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.MainEvent

interface DataSource {

    suspend fun getMainEvent(): NetworkResponse<MainEvent>
}