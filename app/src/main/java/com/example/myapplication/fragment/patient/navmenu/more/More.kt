package com.example.myapplication.fragment.patient.navmenu.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMoreBinding

class More : Fragment() {
    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoreBinding.inflate(inflater, container, false)

        binding.account.setOnClickListener {
            findNavController().navigate(R.id.action_more_to_account)
        }
        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.action_more_to_settings)
        }
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_more_to_mainPagePatient)
        }

        return binding.root
    }
}