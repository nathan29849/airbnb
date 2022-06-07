package com.example.airbnb.ui.settingcompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.airbnb.R
import com.example.airbnb.databinding.FragmentPriceSettingBinding
import com.example.airbnb.ui.common.*
import com.example.airbnb.ui.theme.DivideGray
import com.stfalcon.pricerangebar.model.BarEntry
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat

@AndroidEntryPoint
class PriceSettingFragment : Fragment() {

    lateinit var binding: FragmentPriceSettingBinding
    private val formatter = DecimalFormat("#,###")
    private val viewModel by activityViewModels<SettingViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_price_setting, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initChart()
        listenMaxPinPointChange()
        listenMinPinPointChange()
        setPriceSettingCompose()
    }

    private fun setPriceSettingCompose() {
        binding.cvPriceRange.setContent {
            SetRangeBox(viewModel)
        }
    }


    private fun listenMaxPinPointChange() {
        binding.priceRangeBar.onRightPinChanged = { _, rightPinValue ->
            val rangeTextMin = viewModel.topContent.value.split(" - ")[0]
            val rangeTextMax = rightPinValue?.toFloat()?.toInt()?.let {
                if (it >= 10) formatter.format(
                    PRICE_MAX_VALUE * TEN_MAAN
                ) + "+"
                else (formatter.format(rightPinValue.toFloat().toInt().times(TEN_MAAN)))
            }
            viewModel.changeRangeContent("$rangeTextMin - ₩$rangeTextMax")
        }
    }

    private fun listenMinPinPointChange() {
        binding.priceRangeBar.onLeftPinChanged = { _, leftPinValue ->
            val rangeTextMin = leftPinValue?.toFloat()?.toInt()?.let {
                formatter.format(leftPinValue.toFloat().toInt().times(TEN_MAAN))
            }
            val rangeTextMax = viewModel?.topContent?.value?.split(" - ")?.get(1)
            viewModel?.changeRangeContent("₩$rangeTextMin - $rangeTextMax")
        }
    }

    private fun initChart() {

        val priceHashMap = getPriceData()

        val seekBarEntries = ArrayList<BarEntry>()
        for (i in PRICE_MIN_VALUE..PRICE_MAX_VALUE) {
            priceHashMap[i]?.let {

                seekBarEntries.add(BarEntry(i.toFloat(), it.toFloat()))
                seekBarEntries.add(BarEntry(i + SEEKBAR_VALUE_GAP, it.toFloat()))

                seekBarEntries.add(BarEntry(i + SEEKBAR_VALUE_GAP, SEEKBAR_VACANT_VALUE))
                seekBarEntries.add(
                    BarEntry(
                        i + SEEKBAR_VALUE_GAP + SEEKBAR_VACANT_GAP,
                        SEEKBAR_VACANT_VALUE
                    )
                )
            } ?: kotlin.run {
                seekBarEntries.add(BarEntry(i.toFloat(), SEEKBAR_VACANT_VALUE))
                seekBarEntries.add(BarEntry(i + SEEKBAR_VALUE_GAP, SEEKBAR_VACANT_VALUE))

                seekBarEntries.add(BarEntry(i + SEEKBAR_VALUE_GAP, SEEKBAR_VACANT_VALUE))
                seekBarEntries.add(
                    BarEntry(
                        i + SEEKBAR_VALUE_GAP + SEEKBAR_VACANT_GAP,
                        SEEKBAR_VACANT_VALUE
                    )
                )
            }
        }
        binding.priceRangeBar.setEntries(seekBarEntries)
    }

    // key : 2(20만원 이상 30만원 미만) , value(해당 범위내의 개수)
    private fun getPriceData(): HashMap<Int, Int> {
        val hashMap = HashMap<Int, Int>()

        //TODO 추후 viewModel 을 통해 데이터 가져오기
        val dataSet =
            listOf<Int>(11, 20, 30, 55, 100, 400, 23, 43, 22, 71, 45, 44, 43, 65, 11, 13, 26, 24)
        dataSet.forEach {
            val key = if (it / 10 >= 10) 10 else it / 10
            hashMap[key] = hashMap[key]?.plus(1) ?: 1
        }
        return hashMap
    }

}

@Composable
private fun DrawRangeCompose(explain: String, value: String) {
    Column(
        modifier = Modifier
            .background(DivideGray)
            .fillMaxWidth()
            .fillMaxWidth()
            .padding(start = 13.dp, bottom = 10.dp, top = 7.dp)
    )
    {
        Text(text = explain, fontSize = 15.sp)
        Text(text = value, fontSize = 20.sp)
    }
}

@Composable
private fun SetRangeBox(viewModel: SettingViewModel) {
    val content by viewModel.topContent.collectAsState()
    val page by viewModel.nowFragment.collectAsState()
    if (page is PricePage) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            DrawRangeCompose("최저요금", content.split(" - ")[0].replace("₩", ""))
            Spacer(modifier = Modifier.height(15.dp))
            DrawRangeCompose("최저요금", content.split(" - ")[1].replace("₩", ""))
        }
    }
}


