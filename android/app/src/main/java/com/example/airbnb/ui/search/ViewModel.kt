package com.example.airbnb.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.data.mainrepository.MainRepository
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.PostLocation
import com.example.airbnb.network.dto.Region
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    private val _heroImage: MutableStateFlow<String> = MutableStateFlow("")
    val heroImage: StateFlow<String> = _heroImage

    private val _closeTravel: MutableStateFlow<List<Region>> = MutableStateFlow(emptyList())
    val closeTravel: StateFlow<List<Region>> = _closeTravel

    private val _errorMessage: MutableSharedFlow<String> = MutableSharedFlow(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val errorMessage: SharedFlow<String> = _errorMessage

    fun loadSearchContents(postLocation: PostLocation) {
        viewModelScope.launch() {
            launch {
                when (val response = mainRepository.getMainEvent()) {
                    is NetworkResponse.Success -> _heroImage.value = response.body.events[0].mainImage
                    is NetworkResponse.Error -> _errorMessage.emit(response.errorMessage)
                }
            }
            launch {
                when (val response = mainRepository.getMainRegions(postLocation)) {
                    is NetworkResponse.Success -> _closeTravel.value = response.body.regions
                    is NetworkResponse.Error -> _errorMessage.emit(response.errorMessage)
                }
            }
        }
    }
}