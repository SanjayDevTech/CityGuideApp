package com.sanjaydevtech.cityguide

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object AdapterModule {

    @Provides
    @FragmentScoped
    fun providesListPlacesAdapter(
        @ActivityContext context: Context
    ): ListPlacesAdapter {
        return ListPlacesAdapter(context)
    }
}