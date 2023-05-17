package com.example.myapplication.fragment.patient.medicalhistory.medicalcondition.diagnosis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentDiagnosisListBinding

class DiagnosisAdapter(private val diagnosisList: ArrayList<DiagnosisList>, val listener: DiagnosisAdapter.MyClickListener) :
    RecyclerView.Adapter<DiagnosisAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentDiagnosisListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.details.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentDiagnosisListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return diagnosisList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.type.text = diagnosisList[position].spec
        holder.itemBinding.date.text = diagnosisList[position].time
        holder.itemBinding.chronic.text = diagnosisList[position].chronic
        holder.itemBinding.active.text = diagnosisList[position].active
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}