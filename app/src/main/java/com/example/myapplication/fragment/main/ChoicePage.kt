package com.example.myapplication.fragment.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.activity.MainPagePatient
import com.example.myapplication.databinding.FragmentChoicePageBinding
import com.example.myapplication.databinding.FragmentLoginBinding

class ChoicePage : Fragment() {

    private lateinit var binding: FragmentChoicePageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChoicePageBinding.inflate(inflater, container, false)

        binding.Doctor.setOnClickListener {
            findNavController().navigate(R.id.action_choicePage_to_loginD)
        }
        binding.Patient.setOnClickListener {
            findNavController().navigate(R.id.action_choicePage_to_main)
        }

        return binding.root
    }

}