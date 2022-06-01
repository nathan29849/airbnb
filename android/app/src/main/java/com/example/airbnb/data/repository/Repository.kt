package com.example.airbnb.data.repository

import com.example.airbnb.network.dto.SearchContents
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val dataSource: DataSource){

    suspend fun loadSearchContents(): Flow<SearchContents?> {
        return dataSource.loadSearchContents()
    }
}