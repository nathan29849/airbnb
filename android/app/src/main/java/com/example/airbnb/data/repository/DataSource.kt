package com.example.airbnb.data.repository

import com.example.airbnb.network.dto.SearchContents
import kotlinx.coroutines.flow.Flow

interface DataSource {

    suspend fun loadSearchContents(): Flow<SearchContents?>
}