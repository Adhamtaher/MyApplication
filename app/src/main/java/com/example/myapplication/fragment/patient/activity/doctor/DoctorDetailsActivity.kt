package com.example.myapplication.fragment.patient.activity.doctor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDoctorDetailsActivityBinding

class DoctorDetailsActivity : Fragment() {
    private lateinit var binding: FragmentDoctorDetailsActivityBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoctorDetailsActivityBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.cancel.setOnClickListener {
            findNavController().navigate(R.id.action_doctorDetailsActivity_to_mainPagePatient)
        }

        return binding.root
    }
}