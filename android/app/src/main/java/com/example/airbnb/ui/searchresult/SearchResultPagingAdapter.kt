package com.example.airbnb.ui.searchresult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb.databinding.ItemSearchResultBinding
import com.example.airbnb.network.dto.Accommodation

class SearchResultPagingAdapter : PagingDataAdapter<Accommodation, SearchResultPagingAdapter.SearchResultViewHolder>(ResultDiffCallBack){

    private lateinit var binding: ItemSearchResultBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        binding = ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class SearchResultViewHolder(private val binding: ItemSearchResultBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Accommodation) {
            binding.result = result
        }
    }

    object ResultDiffCallBack : DiffUtil.ItemCallback<Accommodation>() {
        override fun areItemsTheSame(oldItem: Accommodation, newItem: Accommodation): Boolean {
            return oldItem.accommodationId == newItem.accommodationId
        }

        override fun areContentsTheSame(oldItem: Accommodation, newItem: Accommodation): Boolean {
            return oldItem == newItem
        }
    }
}