package com.example.myapplication.fragment.patient.activity.radiation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAnalysisDetailsBinding
import com.example.myapplication.databinding.FragmentRadiationDetailsBinding

class RadiationDetails : Fragment() {
    private lateinit var binding: FragmentRadiationDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadiationDetailsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.cancel.setOnClickListener {
            findNavController().navigate(R.id.action_radiationDetails_to_mainPagePatient)
        }

        return binding.root
    }
}