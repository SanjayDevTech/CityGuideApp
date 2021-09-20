package com.sanjaydevtech.cityguide.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.sanjaydevtech.cityguide.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object MainActivityModule {

    @Provides
    fun providesNavController(
        activity: Activity
    ): NavController {
        return ((activity as AppCompatActivity).supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
    }
}