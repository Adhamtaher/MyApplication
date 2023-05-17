package com.example.myapplication.fragment.patient.mainpage.examinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAnalysisBookingBinding
import com.example.myapplication.databinding.FragmentRadiationBookingBinding

class RadiationBooking : Fragment() {
    private lateinit var binding: FragmentRadiationBookingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadiationBookingBinding.inflate(inflater, container, false)
        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.confirm.setOnClickListener {
            findNavController().navigate(R.id.action_radiationBooking_to_mainPagePatient)
        }

        return binding.root
    }
}