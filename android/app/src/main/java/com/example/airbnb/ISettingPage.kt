package com.example.airbnb

import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.airbnb.ui.PriceSettingFragment

interface ISettingPage {
    fun changePage(fragmentManager: FragmentManager, containerId: Int)
}

class HeadCountPage : ISettingPage {
    override fun changePage(fragmentManager: FragmentManager, container: Int) {
        fragmentManager.commit {
            replace(
                R.id.setting_fragment_container,
                HeadCountFragment()
            )
        }
    }

}

class CalendarPage : ISettingPage {
    override fun changePage(fragmentManager: FragmentManager, container: Int) {
        TODO("Not yet implemented")
    }

}

class PricePage : ISettingPage {
    override fun changePage(fragmentManager: FragmentManager, container: Int) {
        fragmentManager.commit {
            replace(
                R.id.setting_fragment_container,
                PriceSettingFragment()
            )
        }
    }

}