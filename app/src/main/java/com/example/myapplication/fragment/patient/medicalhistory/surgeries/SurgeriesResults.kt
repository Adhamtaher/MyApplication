package com.example.myapplication.fragment.patient.medicalhistory.surgeries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRadiationResultsBinding
import com.example.myapplication.databinding.FragmentSurgeriesResultsBinding

class SurgeriesResults : Fragment() {
    private lateinit var binding: FragmentSurgeriesResultsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSurgeriesResultsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        return binding.root
    }
}