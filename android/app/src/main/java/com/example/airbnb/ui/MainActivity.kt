package com.example.airbnb.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.airbnb.R
import com.example.airbnb.databinding.ActivityMainBinding
import com.example.airbnb.ui.search.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ViewModel by viewModels()
    lateinit var activityResult : ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        viewModel.loadSearchContents()

        NavigationUI.setupWithNavController(
            binding.bottomNavigation,
            findNavController(R.id.nav_host)
        )


        binding.bottomNavigation.setupWithNavController(findNavController(R.id.nav_host))
    }
}