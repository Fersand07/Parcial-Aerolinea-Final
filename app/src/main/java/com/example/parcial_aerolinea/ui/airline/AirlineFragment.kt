package com.example.parcial_aerolinea.ui.airline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parcial_aerolinea.R
import com.example.parcial_aerolinea.databinding.FragmentAirlineBinding
import com.example.parcial_aerolinea.ui.airline.viewmodel.AirlineViewModel


class AirlineFragment : Fragment() {

    private val airlineViewModel: AirlineViewModel by activityViewModels {
        AirlineViewModel.Factory
    }

    private lateinit var binding: FragmentAirlineBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAirlineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel(){
        binding.viewmodel = airlineViewModel
    }
}