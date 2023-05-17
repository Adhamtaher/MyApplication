package com.example.myapplication.fragment.doctor.surgeries

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPrescriptionBinding
import com.example.myapplication.databinding.FragmentReserveSurgeriesBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ReserveSurgeries : Fragment() {
    private lateinit var binding: FragmentReserveSurgeriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReserveSurgeriesBinding.inflate(inflater, container, false)

        val myCalender = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH, month)
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val myFormat = "dd-MM-yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            binding.datepick.setText(sdf.format(myCalender.time))
        }
        binding.datepick.setOnClickListener {
            DatePickerDialog(requireContext(), datePicker, myCalender.get(Calendar.YEAR), myCalender.get(
                Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_reserveSurgeries_to_surgeriesTypes)
        }
        binding.confirm.setOnClickListener {
            findNavController().navigate(R.id.action_reserveSurgeries_to_mainPageDoctor)
        }

        return binding.root
    }
}