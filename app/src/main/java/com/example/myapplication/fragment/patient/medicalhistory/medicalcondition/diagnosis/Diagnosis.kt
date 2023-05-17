package com.example.myapplication.fragment.patient.medicalhistory.medicalcondition.diagnosis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDiagnosisBinding
import java.util.ArrayList

class Diagnosis : Fragment(), DiagnosisAdapter.MyClickListener {

    lateinit var adapter: DiagnosisAdapter
    lateinit var diagnosisList: ArrayList<DiagnosisList>

    lateinit var type : Array<String>
    lateinit var time : Array<String>
    lateinit var chronic : Array<String>
    lateinit var active : Array<String>

    private lateinit var binding: FragmentDiagnosisBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiagnosisBinding.inflate(inflater, container, false)
        dataIntialize()
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = DiagnosisAdapter(diagnosisList, this@Diagnosis)
        binding.recyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        return binding.root
    }
    private fun dataIntialize() {
        diagnosisList = arrayListOf<DiagnosisList>()
        type = arrayOf(
            getString(R.string.diagnosis1),
            getString(R.string.diagnosis2)
        )
        time = arrayOf(
            getString(R.string.diagnose_date1),
            getString(R.string.diagnose_date2)
        )
        chronic = arrayOf(
            getString(R.string.chronic1),
            getString(R.string.chronic2)
        )
        active = arrayOf(
            getString(R.string.active),
            getString(R.string.active2)
        )
        for (i in type.indices) {
            val diagnosis = DiagnosisList(type[i], time[i], chronic[i], active[i])
            diagnosisList.add(diagnosis)
        }
    }
    override fun onClick(position: Int) {
        when(position){
            0-> findNavController().navigate(R.id.action_diagnosis2_to_diagnosisDetails)
            1-> findNavController().navigate(R.id.action_diagnosis2_to_diagnosisDetails)
        }
    }
}
