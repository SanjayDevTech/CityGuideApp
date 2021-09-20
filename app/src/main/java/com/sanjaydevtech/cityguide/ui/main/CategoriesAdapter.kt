package com.sanjaydevtech.cityguide.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sanjaydevtech.cityguide.data.LocalDataSource
import com.sanjaydevtech.cityguide.databinding.LayoutCategoryBinding
import com.sanjaydevtech.cityguide.model.Category
import com.sanjaydevtech.cityguide.model.PlaceCategory
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class CategoriesAdapter @Inject constructor(
    private val navController: NavController,
): RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private val categoriesList = LocalDataSource.fetchCategories()

    inner class CategoryViewHolder(private val binding: LayoutCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.titlePlace.text = category.title
            binding.imgPreview.load(category.image) {
                crossfade(true)
            }
            binding.root.setOnClickListener {
                val action = CategoriesFragmentDirections.openListPlaces(category)
                navController.navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = LayoutCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size
}