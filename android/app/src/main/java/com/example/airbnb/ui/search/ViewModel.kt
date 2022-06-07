package com.example.airbnb.ui.search

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.data.repository.Repository
import com.example.airbnb.network.common.NetworkResponse
import com.example.airbnb.network.dto.PostLocation
import com.example.airbnb.network.dto.Region
import com.google.android.gms.location.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private var mFusedLocationProviderClient: FusedLocationProviderClient? =
        null // 현재 위치를 가져오기 위한 변수
    lateinit var mLastLocation: Location // 위치 값을 가지고 있는 객체
    private lateinit var mLocationRequest: LocationRequest // 위치 정보 요청의 매개변수를 저장

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
                when (val response = repository.getMainEvent()) {
                    is NetworkResponse.Success -> _heroImage.value = response.body.events[0].mainImage
                    is NetworkResponse.Error -> _errorMessage.emit(response.errorMessage)
                }
            }
            launch {
                when (val response = repository.getMainRegions(postLocation)) {
                    is NetworkResponse.Success -> _closeTravel.value = response.body.regions
                    is NetworkResponse.Error -> _errorMessage.emit(response.errorMessage)
                }
            }
        }
    }
}