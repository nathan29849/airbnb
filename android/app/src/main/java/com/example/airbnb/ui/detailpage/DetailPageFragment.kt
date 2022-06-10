package com.example.airbnb.ui.detailpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.airbnb.R
import com.example.airbnb.databinding.FragmentDetailPageBinding
import com.example.airbnb.ui.search.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPageFragment : Fragment() {

    private lateinit var binding: FragmentDetailPageBinding
    private val viewModel: DetailPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_page, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }
}