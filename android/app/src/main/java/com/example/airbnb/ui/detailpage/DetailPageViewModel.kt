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

    private val _starRating: MutableLiveData<Double> = MutableLiveData()
    val starRating: LiveData<Double> = _starRating

    private val _location: MutableLiveData<String> = MutableLiveData()
    val location: LiveData<String> = _location

    private val _hostName: MutableLiveData<String> = MutableLiveData()
    val hostName: LiveData<String> = _hostName

    private val _hostImage: MutableLiveData<String> = MutableLiveData()
    val hostImage: LiveData<String> = _hostImage

    private val _bathroomCount: MutableLiveData<Int> = MutableLiveData()
    val bathroomCount: LiveData<Int> = _bathroomCount

    private val _bedCount: MutableLiveData<Int> = MutableLiveData()
    val bedCount: LiveData<Int> = _bedCount

    private val _maximumGuestNumber: MutableLiveData<Int> = MutableLiveData()
    val maximumGuestNumber: LiveData<Int> = _maximumGuestNumber

    private val _roomCount: MutableLiveData<Int> = MutableLiveData()
    val roomCount: LiveData<Int> = _roomCount

    private val _errorMessage: MutableSharedFlow<String> = MutableSharedFlow(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val errorMessage: SharedFlow<String> = _errorMessage

    fun loadDetailPage(accommodationId: Int) {
        viewModelScope.launch {
            when (val response = detailPageRepository.loadDetailPage(accommodationId)) {
                is NetworkResponse.Success -> {
                    _starRating.value = response.body.starRating
                    _location.value = response.body.location
                    _hostName.value = response.body.hostName
                    _hostImage.value = response.body.hostImage
                    _bathroomCount.value = response.body.accommodationDetails.bathroomCount
                    _bedCount.value = response.body.accommodationDetails.bedCount
                    _maximumGuestNumber.value = response.body.accommodationDetails.maximumGuestNumber
                    _roomCount.value = response.body.accommodationDetails.roomCount
                }
                is NetworkResponse.Error -> _errorMessage.emit(response.errorMessage)
            }
        }
    }
}