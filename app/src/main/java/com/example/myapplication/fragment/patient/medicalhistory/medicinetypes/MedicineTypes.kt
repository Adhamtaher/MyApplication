package com.example.myapplication.fragment.patient.medicalhistory.medicinetypes

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
import com.example.myapplication.databinding.FragmentAnalysisBinding
import com.example.myapplication.databinding.FragmentMedicineTypesBinding
import com.example.myapplication.fragment.mainpage.doctors.speciality.AnalysisList
import java.util.ArrayList
import java.util.Locale

class MedicineTypes : Fragment(), MedicineTypesAdapter.MyClickListener {

    lateinit var adapter: MedicineTypesAdapter
    lateinit var medicinetypesList: ArrayList<MedicineTypesList>
    lateinit var searchView: SearchView

    lateinit var imageId: Array<Int>
    lateinit var heading : Array<String>

    private lateinit var binding: FragmentMedicineTypesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicineTypesBinding.inflate(inflater, container, false)
        dataIntialize()
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = MedicineTypesAdapter(medicinetypesList, this@MedicineTypes)
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
            val filteredList = ArrayList<MedicineTypesList>()
            for (i in medicinetypesList){
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
        medicinetypesList = arrayListOf<MedicineTypesList>()
        imageId = arrayOf(
            R.drawable.noun_capsules_4296858,
            R.drawable.liquid,
            R.drawable.drops,
            R.drawable.inhalers,
            R.drawable.injections,
            R.drawable.creams,
            R.drawable.supp,
            R.drawable.patches
        )
        heading = arrayOf(
            getString(R.string.mt1),
            getString(R.string.mt2),
            getString(R.string.mt3),
            getString(R.string.mt4),
            getString(R.string.mt5),
            getString(R.string.mt6),
            getString(R.string.mt7),
            getString(R.string.mt8)
        )
        for (i in imageId.indices) {
            val medicinetypes = MedicineTypesList(imageId[i], heading[i])
            medicinetypesList.add(medicinetypes)
        }
    }
    override fun onClick(position: Int) {
        when(position){
            0-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            1-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            2-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            3-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            4-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            5-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            6-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            7-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            8-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)
            9-> findNavController().navigate(R.id.action_medicineTypes_to_medicines2)

        }
    }
}