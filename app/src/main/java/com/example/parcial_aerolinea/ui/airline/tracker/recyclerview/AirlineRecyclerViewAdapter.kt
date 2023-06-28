package com.example.parcial_aerolinea.ui.airline.tracker.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_aerolinea.data.model.AirlineModel
import com.example.parcial_aerolinea.databinding.AirlineItemBinding

class AirlineRecyclerViewAdapter (
    private val clickListener: (AirlineModel) -> Unit
    ): RecyclerView.Adapter<AirlineRecyclerViewHolder>(){
        private val airlines = ArrayList<AirlineModel>()


    fun setData(airlinesList: List<AirlineModel>){
        airlines.clear()
        airlines.addAll(airlinesList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirlineRecyclerViewHolder {
       val binding = AirlineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       return AirlineRecyclerViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AirlineRecyclerViewHolder, position: Int) {
        val airline = airlines[position]
        holder.bind(airline, clickListener)
    }

    override fun getItemCount(): Int {
        return airlines.size
    }

    }


