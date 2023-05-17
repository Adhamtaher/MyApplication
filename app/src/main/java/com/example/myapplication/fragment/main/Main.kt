package com.example.myapplication.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAccountBinding
import com.example.myapplication.databinding.FragmentMainBinding

class Main : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.buttonNewacc.setOnClickListener {
            findNavController().navigate(R.id.action_main_to_register)
        }
        binding.btnExiacc.setOnClickListener {
            findNavController().navigate(R.id.action_main_to_login)
        }

        return binding.root
    }

}