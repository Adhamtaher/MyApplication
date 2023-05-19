package com.example.myapplication.fragment.patient.medicalhistory.medicinetypes.medicine
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDoctorHistoryBinding
import com.example.myapplication.databinding.FragmentMedicinesBinding
import com.example.myapplication.fragment.patient.medicalhistory.medicinetypes.MedicineTypesList
import java.util.ArrayList
import java.util.Locale

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

        binding.searchview.clearFocus()
        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }

    private fun filterList(query: String?){
        if (query != null){
            val filteredList = ArrayList<MedicineList>()
            for (i in medicineList){
                if (i.heading.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show()
            }
            else{
                adapter.setFilteredList(filteredList)

            }
        }
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