package com.example.airbnb

import android.app.Application
import android.util.Log
import androidx.compose.runtime.collectAsState
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

    // 차트관련
    private val _minRange = MutableStateFlow<Int>(RANGE_MIN_INDEX)
    val minRange: StateFlow<Int> = _minRange

    private val _maxRange = MutableStateFlow<Int>(RANGE_MAX_INDEX)
    val maxRange: StateFlow<Int> = _maxRange

    private val _topContent = MutableStateFlow<String>("")
    val topContent: StateFlow<String> = _topContent

    private val _topExplain =
        MutableStateFlow<String>(application.getString(R.string.price_setting_explain))
    val topExplain: StateFlow<String> = _topExplain

    private val _adultQuantity = MutableStateFlow<Int>(0)
    val adultQuantity: StateFlow<Int> = _adultQuantity

    private val _childQuantity = MutableStateFlow<Int>(0)
    val childQuantity: StateFlow<Int> = _childQuantity

    private val _babyQuantity = MutableStateFlow<Int>(0)
    val babyQuantity: StateFlow<Int> = _babyQuantity


    // TODO
    // range 값을 변경시키고 그에 따라 content 를 뷰모델에서 변경하는 방식으로 바꿀것
    fun changeRangeContent(content: String) {
        _topContent.value = content
    }

    fun changeToBeforeFragment() {
        viewModelScope.launch {
            when (_nowFragment.value) {
                is PricePage -> _nowFragment.emit(NonePage())
                else -> {
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

    fun changeToNextFragment() {
        viewModelScope.launch {
            when (_nowFragment.value) {
                is PricePage -> {
                    _nowFragment.emit(HeadCountPage())
                    _topExplain.value =
                        (application.getString(R.string.head_count_setting_explain))
                    _topContent.value = "게스트 ${adultQuantity.value + childQuantity.value}, 유아 ${babyQuantity.value}"
                }
                //Todo
                //calendarPage 구현가능하다면 해당 부분 수정
//                is CalendarPage -> {
//                    _nowFragment.emit(PricePage())
//                    _topExplain.value = (application.getString(R.string.price_setting_explain))
//                    _topContent.value =
//                        "₩${minRange.value} - ₩${formatter.format(maxRange.value * TEN_MAAN)}+"
//                }
                is NonePage -> {
                    _maxRange.value = PRICE_MAX_VALUE
                    _minRange.value = PRICE_MIN_VALUE
                    _nowFragment.emit(PricePage())
                    _topExplain.value = (application.getString(R.string.price_setting_explain))
                    _topContent.value =
                        "₩${minRange.value} - ₩${formatter.format(maxRange.value * TEN_MAAN)}+"
                }
                is HeadCountPage -> {

                }
            }
        }
    }

    fun setAdultQuantity(buttonState: ButtonState) {
        when (buttonState) {
            ButtonState.MINUS -> _adultQuantity.value = _adultQuantity.value.minus(1)
            ButtonState.PLUS -> _adultQuantity.value = _adultQuantity.value.plus(1)
        }
        _topContent.value = "게스트 ${adultQuantity.value + childQuantity.value}, 유아 ${babyQuantity.value}"
    }

    fun setChildQuantity(buttonState: ButtonState) {
        when (buttonState) {
            ButtonState.MINUS -> _childQuantity.value = _childQuantity.value.minus(1)
            ButtonState.PLUS -> _childQuantity.value = _childQuantity.value.plus(1)
        }
        _topContent.value = "게스트 ${adultQuantity.value + childQuantity.value}, 유아 ${babyQuantity.value}"
    }

    fun setBabyQuantity(buttonState: ButtonState) {
        when (buttonState) {
            ButtonState.MINUS -> _babyQuantity.value = _babyQuantity.value.minus(1)
            ButtonState.PLUS -> _babyQuantity.value = _babyQuantity.value.plus(1)
        }
        _topContent.value = "게스트 ${adultQuantity.value + childQuantity.value}, 유아 ${babyQuantity.value}"
    }
}
