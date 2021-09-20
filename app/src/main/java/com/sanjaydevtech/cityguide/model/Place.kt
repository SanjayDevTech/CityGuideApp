package com.sanjaydevtech.cityguide.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val name: String,
    val category: Category,
    val description: String,
    val img: String,
): Parcelable
