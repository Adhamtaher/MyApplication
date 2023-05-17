package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainPagePatientBinding

class MainPagePatient : AppCompatActivity() {
    private lateinit var binding: ActivityMainPagePatientBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPagePatientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation=binding.bottomNavigationView
        navController= Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupWithNavController(bottomNavigation,navController)

    }
}