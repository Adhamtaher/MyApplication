package com.example.myapplication.fragment.patient.navmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentActivityBinding
import com.example.myapplication.databinding.FragmentMedicalHistoryBinding

class MedicalHistory : Fragment() {
    private lateinit var binding: FragmentMedicalHistoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicalHistoryBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_medicalHistory_to_mainPagePatient)
        }
        binding.doctors.setOnClickListener {
            findNavController().navigate(R.id.action_medicalHistory_to_doctorHistory)
        }
        binding.analysis.setOnClickListener {
            findNavController().navigate(R.id.action_medicalHistory_to_analysisHistory)
        }
        binding.radiations.setOnClickListener {
            findNavController().navigate(R.id.action_medicalHistory_to_radiationHistory)
        }
        binding.surgeries.setOnClickListener {
            findNavController().navigate(R.id.action_medicalHistory_to_surgeriesHistory)
        }
        binding.medicalconditions.setOnClickListener {
            findNavController().navigate(R.id.action_medicalHistory_to_medicalCondition)
        }

        return binding.root
    }

}