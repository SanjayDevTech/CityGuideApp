package com.sanjaydevtech.cityguide

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val placeId: String,
    val name: String,
    val category: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val img: String,
): Parcelable
