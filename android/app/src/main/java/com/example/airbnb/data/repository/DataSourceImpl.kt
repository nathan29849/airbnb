package com.example.airbnb.data.repository

import com.example.airbnb.network.RetrofitObject
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.SearchContents
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataSourceImpl @Inject constructor() : DataSource {

    override suspend fun loadSearchContents(): Flow<NetworkResponse<SearchContents>> {
        val response = RetrofitObject.service.getSearchContents()
        return flow {
            emit(response)
        }
    }
}