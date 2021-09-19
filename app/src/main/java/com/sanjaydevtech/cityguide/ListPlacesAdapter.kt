package com.sanjaydevtech.cityguide

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanjaydevtech.cityguide.databinding.LayoutPlaceBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class ListPlacesAdapter @Inject constructor(
    @ActivityContext private val context: Context
) : RecyclerView.Adapter<ListPlacesAdapter.PlaceViewHolder>() {

    private val placesList = mutableListOf<Place>()

    inner class PlaceViewHolder(private val binding: LayoutPlaceBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.root.setOnClickListener {
                val launchIntent = Intent(context, ViewActivity::class.java)
                context.startActivity(launchIntent)
            }
            binding.titlePlace.text = place.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        return PlaceViewHolder(LayoutPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(place = placesList[position])
    }

    override fun getItemCount() = placesList.size
}