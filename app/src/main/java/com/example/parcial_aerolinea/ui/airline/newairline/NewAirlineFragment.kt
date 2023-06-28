package com.example.parcial_aerolinea.ui.airline.newairline

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial_aerolinea.R
import com.example.parcial_aerolinea.databinding.FragmentNewAirlineBinding
import com.example.parcial_aerolinea.ui.airline.viewmodel.AirlineViewModel

class NewAirlineFragment : Fragment() {

    private val airlineViewModel: AirlineViewModel by activityViewModels {
        AirlineViewModel.Factory
    }

    private lateinit var binding: FragmentNewAirlineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewAirlineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = airlineViewModel
    }


    private fun observeStatus(){
        airlineViewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(AirlineViewModel.WRONG_INFORMATION)->{
                    Log.d(APP_TAG, status)
                    airlineViewModel.clearStatus()
                }
                status.equals(AirlineViewModel.AIRLINE_CREATED) ->{
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, airlineViewModel.getAirlines().toString())

                    airlineViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object{
        const val APP_TAG = "APP_TAG"
    }
}
