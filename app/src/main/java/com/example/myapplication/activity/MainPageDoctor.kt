package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainPageDoctorBinding
import com.example.myapplication.databinding.ActivityMainPagePatientBinding

class MainPageDoctor : AppCompatActivity() {
    private lateinit var binding: ActivityMainPageDoctorBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}