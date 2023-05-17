package com.example.myapplication.fragment.doctor.schedule

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
import com.example.myapplication.databinding.FragmentSheduleBinding
import com.example.myapplication.fragment.patient.mainpage.doctors.doctors.DoctorsAdapter
import com.example.myapplication.fragment.patient.mainpage.doctors.doctors.booking.BookingAdapter
import com.example.myapplication.fragment.patient.mainpage.doctors.doctors.booking.BookingList
import java.util.ArrayList
import java.util.Locale

class Shedule : Fragment(), ScheduleAdapter.MyClickListener, PatientAdapter.MyClickListener2, PatientAdapter.MyListener {


    lateinit var adapter: ScheduleAdapter
    lateinit var adapter2: PatientAdapter
    lateinit var scheduleList: ArrayList<ScheduleList>
    lateinit var patientList: ArrayList<PatientList>

    lateinit var date : Array<String>
    lateinit var imageId: Array<Int>
    lateinit var heading : Array<String>
    lateinit var time : Array<String>
    lateinit var last : Array<String>
    lateinit var diagnosis : Array<String>

    private lateinit var binding: FragmentSheduleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSheduleBinding.inflate(inflater, container, false)
        dataIntialize()
        dataIntialize2()

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = ScheduleAdapter(scheduleList, this@Shedule)
        binding.recyclerView.adapter = adapter

        val layoutManager2 = LinearLayoutManager(context)
        binding.recyclerView2.layoutManager = layoutManager2
        binding.recyclerView2.setHasFixedSize(true)
        adapter2 = PatientAdapter(patientList,this@Shedule,this@Shedule)
        binding.recyclerView2.adapter = adapter2



        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_shedule_to_mainPageDoctor)
        }

        return binding.root
    }
    private fun dataIntialize() {
        scheduleList = arrayListOf<ScheduleList>()
        date = arrayOf(
            getString(R.string.sch1),
            getString(R.string.sch2),
            getString(R.string.sch3),
            getString(R.string.sch4),
            getString(R.string.sch5),
            getString(R.string.sch6),
            getString(R.string.sch7)
            )

        for (i in date.indices) {
            val schedule = ScheduleList(date[i])
            scheduleList.add(schedule)
        }
    }
    private fun dataIntialize2() {
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
            getString(R.string.availability_n)
        )

        for (i in imageId.indices) {
            val patient = PatientList(imageId[i], heading[i], time[i], last[i], diagnosis[i])
            patientList.add(patient)
        }
    }
    override fun onClick(position: Int) {
        
    }
    override fun onClick2(position: Int) {
            findNavController().navigate(R.id.action_shedule_to_mainPageDoctor)
    }
    override fun onClik(position: Int) {
            findNavController().navigate(R.id.action_shedule_to_patientDetails)

    }
}