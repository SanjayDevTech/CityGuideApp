package com.sanjaydevtech.cityguide.data

import com.sanjaydevtech.cityguide.model.Category
import com.sanjaydevtech.cityguide.model.Place
import com.sanjaydevtech.cityguide.model.PlaceCategory
import com.sanjaydevtech.cityguide.model.PlaceCategory.*

object LocalDataSource {

    private val places: List<Place> = listOf(
        Place("KG Cinemas", THEATERS.category, "KG Cinemas - Gopala Puram is a popular theatre located at 3, Bungalow Road, Race Course, Near C.S.I. Matriculation Higher Secondary School, Gopala Puram, Central, Coimbatore.", "http://www.ourcities.in/wp-content/uploads/2019/12/KG-Cinemas-1024x584.jpg"),
        Place("Sri Ramakrishna Engineering College", COLLEGES.category, "Sri Ramakrishna Engineering College is an autonomous Engineering college in India founded by Sevaratna Dr. R. Venkatesalu.", "https://www.myfirstcollege.com/wp-content/uploads/2019/04/SOm38HzsDk11032017010626banner2.jpg"),
        Place("KG Cinemas", THEATERS.category, "KG Cinemas - Gopala Puram is a popular theatre located at 3, Bungalow Road, Race Course, Near C.S.I. Matriculation Higher Secondary School, Gopala Puram, Central, Coimbatore.", "http://www.ourcities.in/wp-content/uploads/2019/12/KG-Cinemas-1024x584.jpg"),
        Place("Senthil Kumaran Theaters", THEATERS.category, "Senthil Kumaran Cinemas - Ramnagar is a popular theatre located at 109, Ambal Complex, Gokul Estate, Gokhale Street Main, Near Gandipuram Bus Stand, Ramnagar, East, Coimbatore.", "http://coimbatorecompanies.com/uploads/gallery/senthil-kumaran-theatres.jpg"),
        Place("Coimbatore Institute of Technology", COLLEGES.category, "CIT invites motivated and research- focused faculty with an outstanding academic background, and potential to excel in research and work closely on Off Campus programs.", "https://getmyuni.azureedge.net/college-images-test/coimbatore-institute-of-technology-cit-coimbatore/18df5a46c2c14b4c9be4be5aea1c0b4f.jpeg"),
        Place("Brookefields", MALLS.category, "Brookefields is a shopping mall located on Brookebond Road in Coimbatore, India. It was opened in 2010. The mall has outlets from major clothing and apparel brands and a 06-screens multiplex cinema, along with a food court serving multi-cuisine dishes", "http://www.coimbatorecompanies.com/uploads/images/17641510150091001911638.jpg"),
        Place("Prozone Mall", MALLS.category, "Prozone Malls are designed as large regional dominant centres, each spread across over 500,000 sq.ft. They boast a balanced brand mix of 150+ national & international brands; entertainment centres that include multiplexes, gaming zones & vibrant food courts.", "http://www.walk2mall.com/wp-content/uploads/2017/11/Prozone-mall-coimbatore.jpg?x38619"),
    )

    fun fetchPlaces(): List<Place> = places

    fun fetchPlacesWhereCategory(category: Category?): List<Place> {
        return if (category != null) {
            places.filter { it.category == category }
        } else places
    }

    fun fetchCategories(): List<Category> = enumValues<PlaceCategory>().map { it.category }
}