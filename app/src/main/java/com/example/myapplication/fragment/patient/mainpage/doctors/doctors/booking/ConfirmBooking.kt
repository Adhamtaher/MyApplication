package com.example.myapplication.fragment.patient.mainpage.doctors.doctors.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentConfirmBookingBinding

class ConfirmBooking : Fragment() {
        private lateinit var binding: FragmentConfirmBookingBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentConfirmBookingBinding.inflate(inflater, container, false)

            binding.backButton.setOnClickListener {
                activity?.onBackPressed()
            }
            binding.confirm.setOnClickListener {
                findNavController().navigate(R.id.action_confirmBooking_to_confirmRound)
            }

            return binding.root
        }
    }
