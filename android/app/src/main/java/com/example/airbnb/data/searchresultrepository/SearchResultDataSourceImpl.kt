package com.example.airbnb.data.searchresultrepository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.airbnb.data.model.SearchCondition
import com.example.airbnb.network.RetrofitObject
import com.example.airbnb.network.dto.Accommodation
import com.example.airbnb.ui.searchresult.SearchResultPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchResultDataSourceImpl @Inject constructor() : SearchResultDataSource {

    override fun loadSearchResult(searchCondition: SearchCondition): Flow<PagingData<Accommodation>> {
        return Pager(
            config = PagingConfig(pageSize = 5, enablePlaceholders = false),
            pagingSourceFactory = { SearchResultPagingSource(apiService = RetrofitObject.service, searchCondition) }
        ).flow
    }
}