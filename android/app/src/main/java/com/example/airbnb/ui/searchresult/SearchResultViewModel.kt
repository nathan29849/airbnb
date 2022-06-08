package com.example.airbnb.ui.searchresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.airbnb.data.searchresultrepository.SearchResultRepository
import com.example.airbnb.network.dto.Accommodation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(private val searchResultRepository: SearchResultRepository) : ViewModel() {

    private val _searchResult: MutableStateFlow<PagingData<Accommodation>> = MutableStateFlow(PagingData.empty())
    val searchResult: StateFlow<PagingData<Accommodation>> = _searchResult.asStateFlow()

    fun loadSearchResult() {
        viewModelScope.launch {
            searchResultRepository.loadSearchResult()
                .cachedIn(viewModelScope)
                .collect {
                    _searchResult.value = it
                }
        }
    }
}