package com.example.airbnb.ui.searchresult

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.airbnb.data.model.SearchCondition
import com.example.airbnb.network.APIService
import com.example.airbnb.network.dto.Accommodation

class SearchResultPagingSource(
    private val apiService: APIService,
    private val searchCondition: SearchCondition
    ): PagingSource<Int, Accommodation>() {
    override fun getRefreshKey(state: PagingState<Int, Accommodation>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Accommodation> {
        val start = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = apiService.getSearchResult(
                searchCondition.location,
                searchCondition.checkIn,
                searchCondition.checkOut,
                searchCondition.minPrice,
                searchCondition.maxPrice,
                searchCondition.adult,
                searchCondition.child,
                searchCondition.baby,
                start)

            val prevKey = if (start == STARTING_PAGE_INDEX) {
                null
            } else {
                start - STARTING_PAGE_INDEX
            }

            val nextKey = if (!response.hasNext) {
                null
            } else {
                start + params.loadSize
            }
            LoadResult.Page(response.data.accommodations, prevKey, nextKey)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1
    }
}