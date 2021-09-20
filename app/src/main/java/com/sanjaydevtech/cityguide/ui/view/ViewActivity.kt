package com.sanjaydevtech.cityguide.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.sanjaydevtech.cityguide.databinding.ActivityViewBinding
import com.sanjaydevtech.cityguide.model.Place

class ViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val place = intent.getParcelableExtra<Place>("place")
        if (place == null) {
            finish()
            return
        }
        binding.nameText.text = place.name
        binding.imageView.load(place.img)
        binding.descText.text = place.description
    }
}