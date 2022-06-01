package com.example.airbnb.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.data.repository.Repository
import com.example.airbnb.network.dto.CloseTravelContents
import com.example.airbnb.network.dto.Region
import com.example.airbnb.network.dto.SearchContents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _heroImage: MutableStateFlow<String?> = MutableStateFlow("")
    val heroImage: StateFlow<String?> = _heroImage

    private val _closeTravel: MutableStateFlow<List<Region?>?> = MutableStateFlow(null)
    val closeTravel: StateFlow<List<Region?>?> = _closeTravel

    fun loadSearchContents() {
        viewModelScope.launch {
            repository.loadSearchContents().collect { searchContents ->
                _heroImage.value = searchContents?.data?.event?.get(0)?.mainImage
                _closeTravel.value = searchContents?.data?.region
            }
        }
    }
}