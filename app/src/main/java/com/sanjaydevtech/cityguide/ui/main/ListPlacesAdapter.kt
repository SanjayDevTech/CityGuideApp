package com.sanjaydevtech.cityguide.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sanjaydevtech.cityguide.data.LocalDataSource
import com.sanjaydevtech.cityguide.ui.view.ViewActivity
import com.sanjaydevtech.cityguide.databinding.LayoutPlaceBinding
import com.sanjaydevtech.cityguide.model.Category
import com.sanjaydevtech.cityguide.model.Place
import com.sanjaydevtech.cityguide.model.PlaceCategory
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class ListPlacesAdapter @Inject constructor(
    @ActivityContext private val context: Context
) : RecyclerView.Adapter<ListPlacesAdapter.PlaceViewHolder>() {

    private var placesList = LocalDataSource.fetchPlaces()

    var category: Category? = null
        set(value) {
            field = value
            if (value != null) {
                placesList = LocalDataSource.fetchPlacesWhereCategory(value)
                notifyDataSetChanged()
            }
        }

    inner class PlaceViewHolder(private val binding: LayoutPlaceBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.root.setOnClickListener {
                val launchIntent = Intent(context, ViewActivity::class.java)
                launchIntent.putExtra("place", place)
                context.startActivity(launchIntent)
            }
            binding.imgPreview.load(place.img) {
                crossfade(true)
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