package com.example.myapplication.fragment.patient.navmenu.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAccountBinding
import com.example.myapplication.databinding.FragmentSettingsBinding

class Settings : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_settings_to_more)
        }

        return binding.root
    }
}