package com.example.myapplication.fragment.patient.mainpage.doctors.doctors
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
import java.util.ArrayList
import java.util.Locale

class Doctors : Fragment(), DoctorsAdapter.MyClickListener, DoctorsAdapter.MyListener{

    lateinit var adapter: DoctorsAdapter
    lateinit var doctorList: ArrayList<DoctorsList>
    lateinit var searchView: SearchView

    lateinit var imageId: Array<Int>
    lateinit var heading : Array<String>
    lateinit var time : Array<String>
    lateinit var fee : Array<String>
    lateinit var spec : Array<String>

    private lateinit var binding: FragmentDoctorsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoctorsBinding.inflate(inflater, container, false)
        dataIntialize()

        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = DoctorsAdapter(doctorList, this@Doctors, this@Doctors)
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
            val filteredList = ArrayList<DoctorsList>()
            for (i in doctorList){
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
        doctorList = arrayListOf<DoctorsList>()
        imageId = arrayOf(
            R.drawable.smilingdoctor,
            R.drawable.smilingdoctor
        )
        heading = arrayOf(
            getString(R.string.dr1),
            getString(R.string.dr2)
        )
        time = arrayOf(
            getString(R.string.waiting_time_45_minutes),
            getString(R.string.waiting_time_45_minutes)
        )
        fee = arrayOf(
            getString(R.string.fees1),
            getString(R.string.fees2)
        )
        spec = arrayOf(
            getString(R.string.availability_y),
            getString(R.string.availability_n)
        )
        for (i in imageId.indices) {
            val doctors = DoctorsList(imageId[i], heading[i], time[i], fee[i], spec[i])
            doctorList.add(doctors)
        }
    }
    override fun onClick(position: Int) {
        when(position){
            0-> findNavController().navigate(R.id.action_doctors_to_booking)
            1-> findNavController().navigate(R.id.action_doctors_to_booking)
        }
    }
    override fun onClik(position: Int) {
        when(position){
            0-> findNavController().navigate(R.id.action_doctors_to_confirmBooking)
            1-> findNavController().navigate(R.id.action_doctors_to_confirmBooking)
        }
    }
}