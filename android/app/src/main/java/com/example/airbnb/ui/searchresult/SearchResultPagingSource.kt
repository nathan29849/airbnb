package com.example.airbnb.ui.searchresult

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.airbnb.network.APIService
import com.example.airbnb.network.dto.Accommodation

class SearchResultPagingSource(private val apiService: APIService): PagingSource<Int, Accommodation>() {
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
                "회기",
                "2022-05-23",
            "2022-05-24",
                10000,
                100000,
                3,
                2,
                1,
                start)

            val prevKey = if (start == STARTING_PAGE_INDEX) {
                null
            } else {
                start - STARTING_PAGE_INDEX
            }

            val nextKey = if (!response.hasNext) {
                Log.d("hasNext1", "hasNext")
                null
            } else {
                Log.d("hasNext2", (start + params.loadSize).toString())
                start + params.loadSize
            }
            Log.d("LOAD", response.data.accommodations.toString())
            LoadResult.Page(response.data.accommodations, prevKey, nextKey)

        } catch (e: Exception) {
            Log.d("Exception", e.toString())
            LoadResult.Error(e)
        }
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1
    }
}