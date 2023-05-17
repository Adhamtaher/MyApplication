package com.example.myapplication.fragment.patient.mainpage.analysis

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
import com.example.myapplication.fragment.mainpage.doctors.speciality.AnalysisList
import java.util.ArrayList
import java.util.Locale

class Analysis : Fragment(), AnalysisAdapter.MyClickListener {

    lateinit var adapter: AnalysisAdapter
    lateinit var analysisList: ArrayList<AnalysisList>
    lateinit var searchView: SearchView

    lateinit var imageId: Array<Int>
    lateinit var heading : Array<String>

    private lateinit var binding: FragmentAnalysisBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnalysisBinding.inflate(inflater, container, false)
        dataIntialize()
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = AnalysisAdapter(analysisList, this@Analysis)
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
            val filteredList = ArrayList<AnalysisList>()
            for (i in analysisList){
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
        analysisList = arrayListOf<AnalysisList>()
        imageId = arrayOf(
            R.drawable.blood,
            R.drawable.genetic,
            R.drawable.kidney,
            R.drawable.laboratory,
            R.drawable.prenatal,
            R.drawable.urinalysis
        )
        heading = arrayOf(
            getString(R.string.an1),
            getString(R.string.an2),
            getString(R.string.an3),
            getString(R.string.an4),
            getString(R.string.an5),
            getString(R.string.an6)
        )
        for (i in imageId.indices) {
            val analysis = AnalysisList(imageId[i], heading[i])
            analysisList.add(analysis)
        }
    }
    override fun onClick(position: Int) {
        when(position){
            0-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            1-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            2-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            3-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            4-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            5-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            6-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            7-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            8-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)
            9-> findNavController().navigate(R.id.action_analysis_to_analysisBooking)

        }
    }
}