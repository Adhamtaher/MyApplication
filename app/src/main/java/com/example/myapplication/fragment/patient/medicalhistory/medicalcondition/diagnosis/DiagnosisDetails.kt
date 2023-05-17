package com.example.myapplication.fragment.patient.medicalhistory.medicalcondition.diagnosis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDiagnosisDetailsBinding
import com.example.myapplication.databinding.FragmentSurgeriesResultsBinding

class DiagnosisDetails : Fragment() {
    private lateinit var binding: FragmentDiagnosisDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiagnosisDetailsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        return binding.root
    }
}