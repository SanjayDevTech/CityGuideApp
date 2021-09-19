package com.sanjaydevtech.cityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sanjaydevtech.cityguide.databinding.FragmentListPlacesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListPlacesFragment : Fragment() {

    private var _binding: FragmentListPlacesBinding? = null
    private val binding: FragmentListPlacesBinding
        get() = _binding!!

    @Inject
    lateinit var listPlacesAdapter: ListPlacesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPlacesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.placesRv.adapter = listPlacesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}