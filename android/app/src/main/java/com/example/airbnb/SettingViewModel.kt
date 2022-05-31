package com.example.airbnb

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.ui.common.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val application: Application) : ViewModel() {
    private val formatter = DecimalFormat("#,###")

    private val _nowFragment = MutableStateFlow<ISettingPage>(NonePage())
    val nowFragment: StateFlow<ISettingPage> = _nowFragment

    private val _minRange = MutableStateFlow<Int>(RANGE_MIN_INDEX)
    val minRange: StateFlow<Int> = _minRange

    private val _maxRange = MutableStateFlow<Int>(RANGE_MAX_INDEX)
    val maxRange: StateFlow<Int> = _maxRange

    private val _topContent = MutableStateFlow<String>("")
    val topContent: StateFlow<String> = _topContent

    private val _topExplain =
        MutableStateFlow<String>(application.getString(R.string.price_setting_explain))
    val topExplain: StateFlow<String> = _topExplain

    // TODO
    // range 값을 변경시키고 그에 따라 content 를 뷰모델에서 변경하는 방식으로 바꿀것
    fun changeRangeContent(content: String) {
        _topContent.value = content
    }

    fun changeToNextFragment() {
        viewModelScope.launch {
            when (_nowFragment.value) {
                is PricePage -> {
                    _nowFragment.emit(HeadCountPage())
                    _topExplain.value =
                        (application.getString(R.string.head_count_setting_explain))
                    _topContent.value = "게스트 0, 유아 0"
                }
                is CalendarPage -> {
                    _nowFragment.emit(PricePage())
                    _topExplain.value = (application.getString(R.string.price_setting_explain))
                    _topContent.value =
                        "₩${PRICE_MIN_VALUE} - ₩${formatter.format(PRICE_MAX_VALUE * TEN_MAAN)}+"
                }
                is HeadCountPage -> {

                }
                is NonePage -> {
                    _maxRange.value = PRICE_MAX_VALUE
                    _minRange.value = PRICE_MIN_VALUE
                    _nowFragment.emit(PricePage())
                    _topExplain.value = (application.getString(R.string.price_setting_explain))
                    _topContent.value =
                        "₩${PRICE_MIN_VALUE} - ₩${formatter.format(PRICE_MAX_VALUE * TEN_MAAN)}+"
                }
            }
        }
    }
}
