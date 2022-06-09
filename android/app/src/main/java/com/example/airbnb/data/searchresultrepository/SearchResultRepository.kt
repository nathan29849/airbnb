package com.example.airbnb.data.searchresultrepository

import androidx.paging.PagingData
import com.example.airbnb.data.model.SearchCondition
import com.example.airbnb.network.dto.Accommodation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchResultRepository @Inject constructor(private val searchResultDataSource: SearchResultDataSource) {

    fun loadSearchResult(searchCondition: SearchCondition): Flow<PagingData<Accommodation>> {
        return searchResultDataSource.loadSearchResult(searchCondition)
    }
}