package com.example.parcial_aerolinea.ui.airline.tracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_aerolinea.R
import com.example.parcial_aerolinea.data.model.AirlineModel
import com.example.parcial_aerolinea.databinding.FragmentTrackerBinding
import com.example.parcial_aerolinea.ui.airline.tracker.recyclerview.AirlineRecyclerViewAdapter
import com.example.parcial_aerolinea.ui.airline.viewmodel.AirlineViewModel


class TrackerFragment : Fragment() {

    private val airlineViewModel: AirlineViewModel by activityViewModels {
        AirlineViewModel.Factory
    }

    private lateinit var adapter: AirlineRecyclerViewAdapter
    private lateinit var binding: FragmentTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavCreateNewAirline.setOnClickListener {
            airlineViewModel.clearData()
            it.findNavController().navigate(R.id.action_trackerFragment_to_newAirlineFragment)
        }
    }

    private fun showSelectedItem(airline: AirlineModel) {
        airlineViewModel.setSelectedAirline(airline)
        findNavController().navigate(R.id.action_trackerFragment_to_airlineFragment)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayAirlines() {
        adapter.setData(airlineViewModel.getAirlines())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.itemAirlineRecycleView.layoutManager = LinearLayoutManager(view.context)
        adapter = AirlineRecyclerViewAdapter { selectedAirline ->
            showSelectedItem(selectedAirline)
        }
        binding.itemAirlineRecycleView.adapter = adapter
        displayAirlines()
    }

}