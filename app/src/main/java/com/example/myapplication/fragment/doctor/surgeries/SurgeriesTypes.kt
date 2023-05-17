package com.example.myapplication.fragment.doctor.surgeries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSurgeriesTypesBinding
import java.text.DateFormat
import java.util.Calendar

class SurgeriesTypes : Fragment() {

    private lateinit var binding: FragmentSurgeriesTypesBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSurgeriesTypesBinding.inflate(inflater, container, false)

        binding.upcominsur.setOnClickListener {
            findNavController().navigate(R.id.action_surgeriesTypes_to_surgeries)
        }
        binding.reserve.setOnClickListener {
            findNavController().navigate(R.id.action_surgeriesTypes_to_reserveSurgeries)
        }
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_surgeriesTypes_to_mainPageDoctor)
        }

        return binding.root
    }
}