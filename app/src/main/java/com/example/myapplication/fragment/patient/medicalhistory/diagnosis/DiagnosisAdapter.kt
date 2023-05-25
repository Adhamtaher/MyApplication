package com.example.myapplication.fragment.patient.medicalhistory.diagnosis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentDiagnosisListBinding
import com.example.myapplication.fragment.patient.activity.doctor.DoctorActivityAdapter

class DiagnosisAdapter(private val diagnosisList: ArrayList<DiagnosisList>, val listener: MyClickListener, val onlistener: MyListener) :
    RecyclerView.Adapter<DiagnosisAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentDiagnosisListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.details.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
            itemBinding.cancel.setOnClickListener {
                val position = adapterPosition
                onlistener.onDelete(position)
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
    interface MyListener{
        fun onDelete(position: Int)
    }
    fun removeItem(position: Int) {
        diagnosisList.removeAt(position)
        notifyItemRemoved(position)
    }
}