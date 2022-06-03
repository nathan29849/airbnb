package com.example.airbnb.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.data.repository.Repository
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.Region
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _heroImage: MutableStateFlow<String?> = MutableStateFlow("")
    val heroImage: StateFlow<String?> = _heroImage

    private val _closeTravel: MutableStateFlow<List<Region?>?> = MutableStateFlow(null)
    val closeTravel: StateFlow<List<Region?>?> = _closeTravel

    private val _errorMessage: MutableSharedFlow<String> = MutableSharedFlow(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val errorMessage: SharedFlow<String?> = _errorMessage

    fun loadSearchContents() {
        viewModelScope.launch {
            repository.loadSearchContents().collect { networkResponse ->
                when (networkResponse) {
                    is NetworkResponse.Success -> {
                        _heroImage.value = networkResponse.body?.events?.get(0)?.mainImage
                        _closeTravel.value = networkResponse.body?.regions
                    }
                    is NetworkResponse.Error -> _errorMessage.emit(networkResponse.errorMessage)
                }
            }
        }
    }
}