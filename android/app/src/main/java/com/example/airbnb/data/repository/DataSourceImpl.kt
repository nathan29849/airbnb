package com.example.airbnb.data.repository

import com.example.airbnb.network.RetrofitObject
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.SearchContents
import javax.inject.Inject

class DataSourceImpl @Inject constructor() : DataSource {

    override suspend fun loadSearchContents(): NetworkResponse<SearchContents> {
        return RetrofitObject.service.getSearchContents()
    }
}