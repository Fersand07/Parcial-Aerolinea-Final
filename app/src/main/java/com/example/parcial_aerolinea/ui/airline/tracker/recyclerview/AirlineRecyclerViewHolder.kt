package com.example.parcial_aerolinea.ui.airline.tracker.recyclerview


import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_aerolinea.data.model.AirlineModel
import com.example.parcial_aerolinea.databinding.AirlineItemBinding

class AirlineRecyclerViewHolder(private val binding: AirlineItemBinding):
       RecyclerView.ViewHolder(binding.root) {
    fun bind(airline: AirlineModel, clickListener: (AirlineModel) -> Unit) {
        binding.titleTextView.text = airline.name
        binding.qualificationTextView.text = airline.status
        binding.countryTextView.text = airline.country

        binding.airlineItemCardView.setOnClickListener {
            clickListener(airline)
        }
    }
}