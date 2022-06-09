package com.example.airbnb.ui.searchresult

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airbnb.R
import com.example.airbnb.databinding.FragmentSearchResultBinding
import com.example.airbnb.ui.search.SearchFragmentDirections
import com.example.airbnb.ui.MapActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchResultFragment : Fragment() {

    private lateinit var binding: FragmentSearchResultBinding
    private val viewModel: SearchResultViewModel by viewModels()
    private lateinit var searchResultPagingAdapter: SearchResultPagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_result, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadSearchResult()

        binding.btnJumpToMap.setOnClickListener {
            startActivity(Intent(requireContext(), MapActivity::class.java))
        }

        searchResultPagingAdapter = SearchResultPagingAdapter( object : SearchResultListener {
            override fun goDetail() {
                findNavController().navigate(SearchResultFragmentDirections.actionSearchResultFragmentToDetailPageFragment())
            }
        })
        binding.rvSearchResult.adapter = searchResultPagingAdapter
        binding.rvSearchResult.layoutManager = LinearLayoutManager(requireContext())
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchResult.collectLatest {
                    searchResultPagingAdapter.submitData(it)
                }
            }
        }
    }
}