package com.example.myapplication.fragment.patient.navmenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainPagePatientBinding
import java.text.DateFormat
import java.util.Calendar

class MainPagePatient : Fragment() {

    private lateinit var binding: FragmentMainPagePatientBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPagePatientBinding.inflate(inflater, container, false)

        val calendar = Calendar.getInstance().time
        val dateFormat = DateFormat.getDateInstance(DateFormat.LONG).format(calendar)
        binding.textViewDate.text = dateFormat

        binding.clinicVisit.setOnClickListener {
             findNavController().navigate(R.id.action_mainPagePatient_to_speciality)
        }
        binding.homeVisit.setOnClickListener {
            findNavController().navigate(R.id.action_mainPagePatient_to_speciality)
        }
        binding.doctorCall.setOnClickListener {
            findNavController().navigate(R.id.action_mainPagePatient_to_speciality)
        }
        binding.analysis.setOnClickListener {
            findNavController().navigate(R.id.action_mainPagePatient_to_analysis)
        }
        binding.examinatons.setOnClickListener {
            findNavController().navigate(R.id.action_mainPagePatient_to_radiations)
        }
        binding.ask.setOnClickListener {
            findNavController().navigate(R.id.action_mainPagePatient_to_speciality)
        }
        binding.ordermedicine.setOnClickListener {
            findNavController().navigate(R.id.action_mainPagePatient_to_medicineTypes)
        }

        val phoneNumber = "01011498307"
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:$phoneNumber")

        binding.phonecall.setOnClickListener {
            startActivity(dialIntent)
        }
        binding.searchbtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainPagePatient_to_medicineTypes)
        }


        return binding.root
    }
}