package com.example.myapplication.fragment.patient.navmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentActivityBinding
import com.example.myapplication.databinding.FragmentLoginBinding

class Activity : Fragment() {
    private lateinit var binding: FragmentActivityBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActivityBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_activity_to_mainPagePatient)
        }
        binding.doctors.setOnClickListener {
            findNavController().navigate(R.id.action_activity_to_doctorActivity)
        }
        binding.labAnalysis.setOnClickListener {
            findNavController().navigate(R.id.action_activity_to_analysisActivity)
        }
        binding.radiations.setOnClickListener {
            findNavController().navigate(R.id.action_activity_to_radiationActivity)
        }
        binding.surgeries.setOnClickListener {
            findNavController().navigate(R.id.action_activity_to_surgeriesActivity)
        }
        binding.bill.setOnClickListener {
            findNavController().navigate(R.id.action_activity_to_bill2)
        }

        return binding.root
    }

}