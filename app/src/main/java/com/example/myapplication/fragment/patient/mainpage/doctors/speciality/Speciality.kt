package com.example.myapplication.fragment.patient.mainpage.doctors.speciality

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
import com.example.myapplication.databinding.FragmentDoctorsBinding
import com.example.myapplication.databinding.FragmentSpecialityBinding
import java.util.ArrayList
import java.util.Locale

class Speciality : Fragment(), SpecialityAdapter.MyClickListener {

    lateinit var adapter: SpecialityAdapter
    lateinit var specialityList: ArrayList<SpecialtyList>
    lateinit var searchView: SearchView

    lateinit var imageId: Array<Int>
    lateinit var heading : Array<String>

    private lateinit var binding: FragmentSpecialityBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpecialityBinding.inflate(inflater, container, false)
        dataIntialize()
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = SpecialityAdapter(specialityList, this@Speciality)
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
            val filteredList = ArrayList<SpecialtyList>()
            for (i in specialityList){
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
        specialityList = arrayListOf<SpecialtyList>()
        imageId = arrayOf(
            R.drawable.dermatology,
            R.drawable.dentistry,
            R.drawable.psychiatry,
            R.drawable.pediatrics,
            R.drawable.cardiologys,
            R.drawable.orthopedics,
            R.drawable.gynaecology,
            R.drawable.ear,
            R.drawable.allergy
        )
        heading = arrayOf(
            getString(R.string.sp1),
            getString(R.string.sp2),
            getString(R.string.sp3),
            getString(R.string.sp4),
            getString(R.string.sp5),
            getString(R.string.sp6),
            getString(R.string.sp7),
            getString(R.string.sp8),
            getString(R.string.sp9)
        )
        for (i in imageId.indices) {
            val speciality = SpecialtyList(imageId[i], heading[i])
            specialityList.add(speciality)
        }
    }
    override fun onClick(position: Int) {
        when(position){
            0-> findNavController().navigate(R.id.action_speciality_to_doctors)
            1-> findNavController().navigate(R.id.action_speciality_to_doctors)
            2-> findNavController().navigate(R.id.action_speciality_to_doctors)
            3-> findNavController().navigate(R.id.action_speciality_to_doctors)
            4-> findNavController().navigate(R.id.action_speciality_to_doctors)
            5-> findNavController().navigate(R.id.action_speciality_to_doctors)
            6-> findNavController().navigate(R.id.action_speciality_to_doctors)
            7-> findNavController().navigate(R.id.action_speciality_to_doctors)
            8-> findNavController().navigate(R.id.action_speciality_to_doctors)
            9-> findNavController().navigate(R.id.action_speciality_to_doctors)

        }
    }
}