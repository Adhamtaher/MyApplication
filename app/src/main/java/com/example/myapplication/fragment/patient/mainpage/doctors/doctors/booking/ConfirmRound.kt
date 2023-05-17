package com.example.myapplication.fragment.patient.mainpage.doctors.doctors.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentConfirmRoundBinding

class ConfirmRound : Fragment() {
    private lateinit var binding: FragmentConfirmRoundBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmRoundBinding.inflate(inflater, container, false)

        binding.okbutton.setOnClickListener {
            findNavController().navigate(R.id.action_confirmRound_to_mainPagePatient)
        }

        return binding.root
    }
}
