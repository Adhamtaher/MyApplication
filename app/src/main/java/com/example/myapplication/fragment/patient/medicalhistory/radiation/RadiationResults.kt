package com.example.myapplication.fragment.patient.medicalhistory.radiation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentRadiationResultsBinding

class RadiationResults : Fragment() {
    private lateinit var binding: FragmentRadiationResultsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadiationResultsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        return binding.root
    }
}