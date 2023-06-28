package com.example.parcial_aerolinea.ui.airline.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial_aerolinea.AirlineReviewerApplication
import com.example.parcial_aerolinea.data.model.AirlineModel
import com.example.parcial_aerolinea.repositories.AirlineRepository

class AirlineViewModel (private val repository: AirlineRepository) : ViewModel(){
    var name = MutableLiveData("")
    var country = MutableLiveData("")
    var status = MutableLiveData("")


    fun getAirlines() = repository.getAirlines()

    fun addAirlines(airline: AirlineModel) = repository.addAirlines(airline)

    fun createAirline(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val airline = AirlineModel(
            name.value!!,
            country.value!!,
            status.value!!
        )

        addAirlines(airline)
        clearData()

        status.value = AIRLINE_CREATED
    }

    private fun validateData(): Boolean{
        when {
            name.value.isNullOrEmpty() -> return false
            country.value.isNullOrEmpty() -> return false
            status.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        country.value = ""
        status.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedAirline(airline: AirlineModel){
        name.value = airline.name
        country.value = airline.country
        status.value = airline.status
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as AirlineReviewerApplication
                AirlineViewModel(app.airlineRepository)
            }
        }
        const val AIRLINE_CREATED = "Airline has created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }
}