package com.example.airbnb.ui.detailpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.data.detailpagerepository.DetailPageRepository
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.AccommodationDetails
import com.example.airbnb.network.dto.AccommodationDetailsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor(private val detailPageRepository: DetailPageRepository) : ViewModel() {

    private val _detailPage: MutableLiveData<AccommodationDetails> = MutableLiveData()
    val detailPage: LiveData<AccommodationDetails> = _detailPage

    private val _errorMessage: MutableSharedFlow<String> = MutableSharedFlow(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val errorMessage: SharedFlow<String> = _errorMessage

    fun loadDetailPage(accommodationId: Int) {
        viewModelScope.launch {
            when (val response = detailPageRepository.loadDetailPage(accommodationId)) {
                is NetworkResponse.Success -> _detailPage.value = response.body.accommodationDetails
                is NetworkResponse.Error -> _errorMessage.emit(response.errorMessage)
            }
        }
    }
}