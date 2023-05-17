package com.example.myapplication.fragment.doctor

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
import com.example.myapplication.databinding.FragmentPatientsBinding
import com.example.myapplication.databinding.FragmentSheduleBinding
import com.example.myapplication.fragment.doctor.schedule.PatientAdapter
import com.example.myapplication.fragment.doctor.schedule.PatientList
import com.example.myapplication.fragment.doctor.schedule.ScheduleAdapter
import com.example.myapplication.fragment.doctor.schedule.ScheduleList
import com.example.myapplication.fragment.patient.mainpage.doctors.doctors.DoctorsList
import java.util.ArrayList
import java.util.Locale

class Patients : Fragment(), PatientAdapter.MyClickListener2, PatientAdapter.MyListener {


    lateinit var adapter: PatientAdapter
    lateinit var patientList: ArrayList<PatientList>
    lateinit var searchView: SearchView

    lateinit var date: Array<String>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var time: Array<String>
    lateinit var last: Array<String>
    lateinit var diagnosis: Array<String>

    private lateinit var binding: FragmentPatientsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPatientsBinding.inflate(inflater, container, false)
        dataIntialize()

        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = PatientAdapter(patientList, this@Patients, this@Patients)
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
            findNavController().navigate(R.id.action_patients2_to_mainPageDoctor)
        }

        return binding.root
    }


    private fun filterList(query: String?){
        if (query != null){
            val filteredList = ArrayList<PatientList>()
            for (i in patientList){
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
        patientList = arrayListOf<PatientList>()
        imageId = arrayOf(
            R.drawable.paitent,
            R.drawable.paitent
        )
        heading = arrayOf(
            getString(R.string.pat1),
            getString(R.string.pat2)
        )
        time = arrayOf(
            getString(R.string.visit_time_1),
            getString(R.string.visit_time_2)
        )
        last = arrayOf(
            getString(R.string.last_visit_1),
            getString(R.string.last_visit_2)
        )
        diagnosis = arrayOf(
            getString(R.string.dia1),
            getString(R.string.dia2)
        )

        for (i in imageId.indices) {
            val patient = PatientList(imageId[i], heading[i], time[i], last[i], diagnosis[i])
            patientList.add(patient)
        }
    }

    override fun onClick2(position: Int) {
        findNavController().navigate(R.id.action_patients2_to_mainPageDoctor)
    }

    override fun onClik(position: Int) {
        findNavController().navigate(R.id.action_patients2_to_patientDetails)
    }
}