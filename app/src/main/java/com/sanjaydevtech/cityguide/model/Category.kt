package com.sanjaydevtech.cityguide.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val title: String,
    val image: String,
): Parcelable

enum class PlaceCategory(
    val category: Category
) {
    THEATERS(Category("Theaters", "https://g.foolcdn.com/editorial/images/601021/a-full-movie-theater-with-a-blank-screen.jpg")),
    MALLS(Category("Malls", "https://www.mistay.in/travel-blog/content/images/2020/07/palladium.jpg")),
    HOSPITALS(Category("Hospitals", "https://friedmanrealestate.com/wp-content/uploads/2019/06/hospitals.jpg")),
    TOURIST_VISITS(Category("Tourist Visits", "https://www.indianluxurytrains.com/blog/wp-content/uploads/2014/01/alappuzha-in-kerala.jpg")),
    COLLEGES(Category("Colleges", "https://www.uncf.org/wp-content/uploads/heroes/2018LaneCollege1440.jpg"))
}