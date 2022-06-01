package com.example.airbnb.data.repository

import com.example.airbnb.common.AssetLoader
import com.example.airbnb.network.RetrofitObject
import com.example.airbnb.network.dto.SearchContents
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private val assetLoader: AssetLoader) : DataSource {

    override suspend fun loadSearchContents(): Flow<SearchContents?> {
        val response = RetrofitObject.service.getSearchContents()
        return flow {
            emit(response.getBodyOrException())
        }
    }

    private fun <T> Response<T>.getBodyOrException(): T? {
        return if (this.isSuccessful) this.body() else throw Exception()
    }
}