package com.example.airbnb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb.databinding.ItemCloseTravelBinding

class SearchCloseTravelAdapter : ListAdapter<SearchCloseTravel, SearchCloseTravelAdapter.SearchCloseTravelAdapterHolder>(FileDiffCallBack) {

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
        fun bind(travels: SearchCloseTravel) {
            binding.travels = travels
            binding.executePendingBindings()
        }
    }

    object FileDiffCallBack : DiffUtil.ItemCallback<SearchCloseTravel>() {
        override fun areItemsTheSame(
            oldItem: SearchCloseTravel,
            newItem: SearchCloseTravel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SearchCloseTravel,
            newItem: SearchCloseTravel
        ): Boolean {
            return oldItem == newItem
        }
    }
}