package com.example.airbnb

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingViewModel : ViewModel() {
    private val _nowFragment = MutableStateFlow<ISettingPage>(PricePage())
    val nowFragment: StateFlow<ISettingPage> = _nowFragment

    fun changeToNextFragment() {
        when (_nowFragment.value) {
            is PricePage -> {
                _nowFragment.value = HeadCountPage()
            }
            is CalendarPage -> {
                _nowFragment.value = PricePage()
            }
            is HeadCountPage -> {
                // 추후 구현 예정
                //_nowFragment.value = PricePage()
            }
        }
    }
}