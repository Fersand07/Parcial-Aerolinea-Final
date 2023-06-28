package com.example.parcial_aerolinea.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcial_aerolinea.R
import com.example.parcial_aerolinea.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private lateinit var binding: ActivityMainBinding
}