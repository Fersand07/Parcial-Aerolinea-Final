package com.example.parcial_aerolinea.repositories

import com.example.parcial_aerolinea.data.model.AirlineModel

class AirlineRepository(private val airlines: MutableList<AirlineModel>) {

    fun getAirlines() = airlines

    fun addAirlines(airline: AirlineModel) = airlines.add(airline)

}