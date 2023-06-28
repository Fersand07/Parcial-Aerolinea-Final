package com.example.parcial_aerolinea.data

import com.example.parcial_aerolinea.data.model.AirlineModel

val name = "Avianca"
val country = "El Salvador"
val status = "Available"

var airlines = mutableListOf(
    AirlineModel(name, country, status)
)