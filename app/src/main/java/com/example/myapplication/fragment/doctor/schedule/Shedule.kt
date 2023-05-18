package com.example.myapplication.fragment.doctor.schedule

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSheduleBinding
import com.example.myapplication.fragment.doctor.surgeries.SurgeriesAdapter
import com.example.myapplication.fragment.doctor.surgeries.SurgeriesList
import kotlin.collections.ArrayList

class Shedule : Fragment(), ScheduleAdapter.MyClickListener, PatientAdapter.MyClickListener2, PatientAdapter.MyListener, SurgeriesAdapter.MyClickListener, SurgeriesAdapter.MyListener {


    lateinit var adapter: ScheduleAdapter
    lateinit var adapter2: PatientAdapter
    lateinit var adapter3: SurgeriesAdapter
    lateinit var scheduleList: ArrayList<ScheduleList>
    lateinit var patientList: ArrayList<PatientList>
    lateinit var surgeriesList: ArrayList<SurgeriesList>

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
        dataIntialize3()

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

        val layoutManager3 = LinearLayoutManager(context)
        binding.recyclerView3.layoutManager = layoutManager3
        binding.recyclerView3.setHasFixedSize(true)
        adapter3 = SurgeriesAdapter(surgeriesList,this@Shedule,this@Shedule)
        binding.recyclerView3.adapter = adapter3

        binding.canceelall.isEnabled = true
        binding.canceelall.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setView(R.layout.alertbox2)
            val dialog = builder.create()
            dialog.show()
            dialog.findViewById<Button>(R.id.btn_yes)?.setOnClickListener {
                val parentView: ViewGroup = binding.recyclerView2.parent as ViewGroup
                val parentView2: ViewGroup = binding.recyclerView3.parent as ViewGroup
                parentView.removeView(binding.recyclerView2)
                parentView2.removeView(binding.recyclerView3)
                binding.canceelall.isEnabled = false
                dialog.dismiss()
            }
            dialog.findViewById<Button>(R.id.btn_cancel)?.setOnClickListener {
                // Do something when the user clicks No button
                dialog.dismiss()
            }

        }
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
    private fun dataIntialize3() {
        surgeriesList = arrayListOf<SurgeriesList>()
        imageId = arrayOf(
            R.drawable.paitent,
            R.drawable.paitent
        )
        heading = arrayOf(
            getString(R.string.pat1),
            getString(R.string.pat2)
        )
        time = arrayOf(
            getString(R.string.operation_time1),
            getString(R.string.operation_time2)
        )
        last = arrayOf(
            getString(R.string.last_visit_1),
            getString(R.string.last_visit_2)
        )
        diagnosis = arrayOf(
            getString(R.string.operation1),
            getString(R.string.operation2)
        )

        for (i in imageId.indices) {
            val surgeries = SurgeriesList(imageId[i], heading[i], time[i], last[i], diagnosis[i])
            surgeriesList.add(surgeries)
        }
    }
    override fun onClickSch(position: Int) {
        
    }
    override fun onDeletePat(position: Int) {
        val builder = AlertDialog.Builder(context)
        builder.setView(R.layout.alertbox1)
        val dialog = builder.create()
        dialog.show()
        dialog.findViewById<Button>(R.id.btn_yes)?.setOnClickListener {
            adapter2.removeItem(position)
            dialog.dismiss()
        }
        dialog.findViewById<Button>(R.id.btn_cancel)?.setOnClickListener {
            // Do something when the user clicks No button
            dialog.dismiss()
        }
    }

    override fun onClickPat(position: Int) {
            findNavController().navigate(R.id.action_shedule_to_patientDetails)

    }
    override fun onClickSur(position: Int) {
        findNavController().navigate(R.id.action_shedule_to_patientDetails)
    }

    override fun onDeleteSur(position: Int) {   val builder = AlertDialog.Builder(context)
        builder.setView(R.layout.alertbox1)
        val dialog = builder.create()
        dialog.show()
        dialog.findViewById<Button>(R.id.btn_yes)?.setOnClickListener {
            adapter3.removeItem(position)
            dialog.dismiss()
        }
        dialog.findViewById<Button>(R.id.btn_cancel)?.setOnClickListener {
            // Do something when the user clicks No button
            dialog.dismiss()
        }
    }
}