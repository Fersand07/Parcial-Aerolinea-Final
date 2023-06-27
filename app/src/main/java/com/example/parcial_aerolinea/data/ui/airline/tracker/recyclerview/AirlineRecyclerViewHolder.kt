package com.example.parcial_aerolinea.data.ui.airline.tracker.recyclerview

import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_aerolinea.data.model.AirlineModel

class AirlineRecyclerViewHolder(private val binding:Airline){
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}