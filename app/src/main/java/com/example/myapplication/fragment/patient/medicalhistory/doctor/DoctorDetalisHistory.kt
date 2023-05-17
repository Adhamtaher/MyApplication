package com.example.myapplication.fragment.patient.medicalhistory.doctor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDoctorDetalisHistoryBinding

class DoctorDetalisHistory : Fragment() {
    private lateinit var binding: FragmentDoctorDetalisHistoryBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoctorDetalisHistoryBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.bookagain.setOnClickListener {
            findNavController().navigate(R.id.action_doctorDetalisHistory_to_booking)
        }

        return binding.root
    }
}
