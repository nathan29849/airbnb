package com.example.airbnb

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.ui.common.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val application: Application) : ViewModel() {
    private val formatter = DecimalFormat("#,###")

    private val _nowFragment = MutableStateFlow<ISettingPage>(PricePage())
    val nowFragment: StateFlow<ISettingPage> = _nowFragment

    private val _topRangeContent =
        MutableStateFlow<String>("₩${PRICE_MIN_VALUE} - ₩${formatter.format(PRICE_MAX_VALUE * TEN_MAAN)}+\"\n")

    val topRangeContent: StateFlow<String> = _topRangeContent

    private val _minRange = MutableStateFlow<Int>(RANGE_MIN_INDEX)
    val minRange: StateFlow<Int> = _minRange

    private val _maxRange = MutableStateFlow<Int>(RANGE_MAX_INDEX)
    val maxRange: StateFlow<Int> = _maxRange

    private val _topExplain =
        MutableStateFlow<String>(application.getString(R.string.price_setting_explain))
    val topExplain: StateFlow<String> = _topExplain


    fun changeRangeContent(content: String) {
        _topRangeContent.value = content
    }

    fun changeToNextFragment() {
        viewModelScope.launch {
            when (_nowFragment.value) {
                is PricePage -> {
                    _nowFragment.value = HeadCountPage()
                    _topExplain.value = (application.getString(R.string.head_count_setting_explain))
                    _topRangeContent.value = "게스트 0, 유아 0"
                }
                is CalendarPage -> {
                    _nowFragment.value = PricePage()
                    _topExplain.value = (application.getString(R.string.date_setting_explain))
                    _topRangeContent.value =
                        "₩${PRICE_MIN_VALUE} - ₩${formatter.format(PRICE_MAX_VALUE * TEN_MAAN)}+"
                }
                is HeadCountPage -> {
                    // 추후 구현 예정
                    //_nowFragment.value = PricePage()
                }
            }
        }
    }
}