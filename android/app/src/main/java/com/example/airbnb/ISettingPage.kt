package com.example.airbnb

import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.airbnb.ui.PriceSettingFragment

interface ISettingPage {
    fun changePage(fragmentManager: FragmentManager, containerId: Int, viewModel: SettingViewModel)
}

class NonePage : ISettingPage{
    override fun changePage(
        fragmentManager: FragmentManager,
        containerId: Int,
        viewModel: SettingViewModel
    ) {
    }

}

class HeadCountPage : ISettingPage {
    override fun changePage(
        fragmentManager: FragmentManager,
        container: Int,
        viewModel: SettingViewModel
    ) {
        fragmentManager.commit {
            replace(
                R.id.setting_fragment_container,
                HeadCountFragment()
            )
        }
    }
}

class CalendarPage : ISettingPage {
    override fun changePage(
        fragmentManager: FragmentManager,
        container: Int,
        viewModel: SettingViewModel
    ) {

    }

}

class PricePage : ISettingPage {
    override fun changePage(
        fragmentManager: FragmentManager,
        container: Int,
        viewModel: SettingViewModel
    ) {
        val fragment = PriceSettingFragment()
        fragment.viewModel = viewModel
        fragmentManager.commit {
            replace(
                R.id.setting_fragment_container, fragment
            )
        }
    }

}