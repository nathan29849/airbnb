package com.example.airbnb.ui.placesearch

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb.R
import com.example.airbnb.data.model.PlaceData
import com.example.airbnb.databinding.ItemPopularPlaceDetailBinding
import com.example.airbnb.databinding.ItemSearchPlaceDetailBinding
import com.example.airbnb.ui.common.ShowCalendarListener

private const val VIEW_TYPE_SEARCH = 1
private const val VIEW_TYPE_DETAIL = 2

class PlaceSearchAdapter(val listener: ShowCalendarListener) :
    ListAdapter<PlaceData, RecyclerView.ViewHolder>(
        diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_SEARCH -> {
                val binding: ItemSearchPlaceDetailBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_search_place_detail,
                    parent,
                    false
                )
                return SearchPlaceViewHolder(binding)
            }
            VIEW_TYPE_DETAIL -> {
                val binding: ItemPopularPlaceDetailBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_popular_place_detail,
                    parent,
                    false
                )
                return PopularPlaceViewHolder(binding)
            }
            else -> {
                error("viewType 을 찾을 수 없습니다.")
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SearchPlaceViewHolder -> {
                holder.bind(getItem(position) as PlaceData.SearchPlaceData)
            }
            is PopularPlaceViewHolder -> {
                holder.bind(getItem(position) as PlaceData.PopularPlaceData)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PlaceData.SearchPlaceData -> VIEW_TYPE_SEARCH
            is PlaceData.PopularPlaceData -> VIEW_TYPE_DETAIL
        }
    }

    inner class SearchPlaceViewHolder(private val binding: ItemSearchPlaceDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(item: PlaceData.SearchPlaceData) {
            binding.item = item
            itemView.setOnClickListener {
                listener.showCalendar()
            }
        }
    }

    class PopularPlaceViewHolder(private val binding: ItemPopularPlaceDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlaceData.PopularPlaceData) {
            binding.item = item
        }
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PlaceData>() {
            override fun areItemsTheSame(
                oldItem: PlaceData,
                newItem: PlaceData
            ): Boolean {
                return when (oldItem) {
                    is PlaceData.SearchPlaceData -> {
                        oldItem.placeName == (newItem as? PlaceData.SearchPlaceData)?.placeName ?: false
                    }
                    is PlaceData.PopularPlaceData -> {
                        oldItem.placeName == (newItem as? PlaceData.PopularPlaceData)?.placeName ?: false
                    }
                }
            }

            override fun areContentsTheSame(
                oldItem: PlaceData,
                newItem: PlaceData
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}