package com.example.myapplication.fragment.patient.medicalhistory.medicinetypes.medicine
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDoctorHistoryBinding
import com.example.myapplication.databinding.FragmentMedicinesBinding
import java.util.ArrayList

class Medicines : Fragment(), MedicineAdapter.MyClickListener{

    lateinit var adapter: MedicineAdapter
    lateinit var medicineList: ArrayList<MedicineList>

    lateinit var imageId: Array<Int>
    lateinit var heading : Array<String>
    lateinit var price : Array<String>
    lateinit var type : Array<String>

    private lateinit var binding: FragmentMedicinesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicinesBinding.inflate(inflater, container, false)
        dataIntialize()
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = MedicineAdapter(medicineList, this@Medicines)
        binding.recyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }
    private fun dataIntialize() {
        medicineList = arrayListOf<MedicineList>()
        imageId = arrayOf(
            R.drawable.augmentin,
            R.drawable.panadol,
            R.drawable.comtrex
        )
        heading = arrayOf(
            getString(R.string.med1),
            getString(R.string.med2),
            getString(R.string.med3)
        )
        price = arrayOf(
            getString(R.string.p1),
            getString(R.string.p2),
            getString(R.string.p3)
        )
        type = arrayOf(
            getString(R.string.mt1),
            getString(R.string.mt1),
            getString(R.string.mt1)
            )
        for (i in imageId.indices) {
            val medicine = MedicineList(imageId[i], heading[i], price[i], type[i])
            medicineList.add(medicine)
        }
    }
    override fun onClick(position: Int) {
        when(position){
        }
    }
}