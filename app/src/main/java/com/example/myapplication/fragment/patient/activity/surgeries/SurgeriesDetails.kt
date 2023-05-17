package com.example.myapplication.fragment.patient.activity.surgeries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentSurgeriesDetailsBinding

class SurgeriesDetails : Fragment() {
    private lateinit var binding: FragmentSurgeriesDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSurgeriesDetailsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        return binding.root
    }
}