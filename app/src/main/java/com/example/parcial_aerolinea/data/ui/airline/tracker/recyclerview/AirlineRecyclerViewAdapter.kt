package com.example.parcial_aerolinea.data.ui.airline.tracker.recyclerview

import com.example.parcial_aerolinea.data.airlines
import com.example.parcial_aerolinea.data.model.AirlineModel
import java.text.FieldPosition

class AirlineRecyclerViewAdapter {

}

fun getItemCount(): Int{
    return airlines.size
}

fun setData(airlinesList: List<AirlineModel>){
    airlines.clear()
    airlines.addAll(airlinesList)
}
