package com.example.parcial_aerolinea

import android.app.Application
import com.example.parcial_aerolinea.data.airlines
import com.example.parcial_aerolinea.data.repositories.AirlineRepository

class AirlineReviewerApplication: Application(){
    val airlineRepository: AirlineRepository by lazy {
        AirlineRepository(airlines)
    }

}