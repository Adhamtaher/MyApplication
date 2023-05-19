package com.example.myapplication.fragment.patient.mainpage.examinations

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAnalysisBookingBinding
import com.example.myapplication.databinding.FragmentRadiationBookingBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RadiationBooking : Fragment() {
    private lateinit var binding: FragmentRadiationBookingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadiationBookingBinding.inflate(inflater, container, false)

        binding.username.isEnabled = false
        binding.phonenumber.isEnabled = false
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.username.isEnabled = isChecked
            binding.phonenumber.isEnabled = isChecked
        }
        val myCalender = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH, month)
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val myFormat = "dd-MM-yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            binding.datepick3.setText(sdf.format(myCalender.time))
        }
        binding.datepick3.setOnClickListener {
            DatePickerDialog(requireContext(), datePicker, myCalender.get(Calendar.YEAR), myCalender.get(
                Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH)).show()
        }
        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.confirm.setOnClickListener {
            findNavController().navigate(R.id.action_radiationBooking_to_mainPagePatient)
        }

        return binding.root
    }
}