package com.sanjaydevtech.cityguide.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sanjaydevtech.cityguide.databinding.FragmentListPlacesBinding
import com.sanjaydevtech.cityguide.ui.main.ListPlacesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListPlacesFragment : Fragment() {

    private var _binding: FragmentListPlacesBinding? = null
    private val binding: FragmentListPlacesBinding
        get() = _binding!!

    @Inject
    lateinit var listPlacesAdapter: ListPlacesAdapter

    private val args by navArgs<ListPlacesFragmentArgs>()

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
        listPlacesAdapter.category = args.category
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}