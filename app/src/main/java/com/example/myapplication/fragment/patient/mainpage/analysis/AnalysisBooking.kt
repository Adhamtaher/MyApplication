package com.example.myapplication.fragment.patient.mainpage.analysis

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAnalysisBookingBinding


class AnalysisBooking : Fragment() {
    private lateinit var binding: FragmentAnalysisBookingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnalysisBookingBinding.inflate(inflater, container, false)
        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.confirm.setOnClickListener {
            findNavController().navigate(R.id.action_analysisBooking_to_mainPagePatient)
        }

        binding.apply {
            tanggal.setOnClickListener {
                val datePickerFragment = DatePickerFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager

                //we have to implement  setFragmentResultListener
                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY"){
                        val date = bundle.getString("SELECTED_DATE")
                        tanggalAnda.text= date

                    }
                }
            }

        }

        return binding.root
    }
}