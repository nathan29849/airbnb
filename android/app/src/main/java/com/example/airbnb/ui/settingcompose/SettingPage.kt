package com.example.airbnb.ui.settingcompose

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.airbnb.R

interface ISettingPage {
    fun changePage(fragmentManager: FragmentManager, containerId: Int, viewModel: SettingViewModel)
}

class NonePage : ISettingPage {
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
        fragmentManager.commit {
            replace(
                R.id.setting_fragment_container, fragment
            )
        }
    }

}