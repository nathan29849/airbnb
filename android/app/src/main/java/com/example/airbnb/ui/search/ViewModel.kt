package com.example.airbnb.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.airbnb.data.repository.Repository
import com.example.airbnb.network.dto.CloseTravelContents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _heroImage: MutableStateFlow<String?> = MutableStateFlow("")
    val heroImage: LiveData<String?> = _heroImage.asLiveData()

    private val _closeTravel: MutableStateFlow<List<CloseTravelContents?>?> = MutableStateFlow(null)
    val closeTravel: LiveData<List<CloseTravelContents?>?> = _closeTravel.asLiveData()

    fun loadSearchContents() {
        viewModelScope.launch {
            launch {
                val heroImage = repository.loadHeroImage()
                _heroImage.value = heroImage?.imageUrl
            }
            launch {
                val closeTravelContents = repository.loadCloseTravel()
                _closeTravel.value = closeTravelContents?.closeTravel
            }
        }
    }
}