package com.example.airbnb.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb.databinding.ItemCloseTravelBinding
import com.example.airbnb.network.dto.Region

class SearchCloseTravelAdapter : ListAdapter<Region, SearchCloseTravelAdapter.SearchCloseTravelAdapterHolder>(
    FileDiffCallBack
) {

    private lateinit var binding: ItemCloseTravelBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchCloseTravelAdapterHolder {
        binding = ItemCloseTravelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchCloseTravelAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchCloseTravelAdapterHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchCloseTravelAdapterHolder(private val binding: ItemCloseTravelBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(region: Region) {
            binding.region = region
            binding.executePendingBindings()
        }
    }

    object FileDiffCallBack : DiffUtil.ItemCallback<Region>() {
        override fun areItemsTheSame(
            oldItem: Region,
            newItem: Region
        ): Boolean {
            return oldItem.categoryId == newItem.categoryId
        }

        override fun areContentsTheSame(
            oldItem: Region,
            newItem: Region
        ): Boolean {
            return oldItem == newItem
        }
    }
}