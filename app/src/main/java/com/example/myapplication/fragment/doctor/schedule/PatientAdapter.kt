package com.example.myapplication.fragment.doctor.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentDoctorsListBinding
import com.example.myapplication.databinding.FragmentPatientListBinding
import com.example.myapplication.fragment.patient.mainpage.doctors.doctors.DoctorsList

class PatientAdapter(private var patientList: MutableList<PatientList>, val listener: PatientAdapter.MyClickListener2, val onlistener:PatientAdapter.MyListener) :
    RecyclerView.Adapter<PatientAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentPatientListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.cancel.setOnClickListener {
                val position = adapterPosition
                listener.onDeletePat(position)
            }
            itemBinding.check.setOnClickListener {
                val position = adapterPosition
                onlistener.onClickPat(position)
            }
        }

    }
    fun setFilteredList(patientList: ArrayList<PatientList>){
        this.patientList = patientList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentPatientListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return patientList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.patientImage.setImageResource(patientList[position].titleImage)
        holder.itemBinding.patientName.text = patientList[position].heading
        holder.itemBinding.visittime.text = patientList[position].time
        holder.itemBinding.lastvisit.text = patientList[position].last
        holder.itemBinding.diagnosis.text = patientList[position].diagnosis
        holder.itemBinding.cancel.tag = position
    }
    interface MyClickListener2{
        fun onDeletePat(position: Int)
    }
    interface MyListener{
        fun onClickPat(position: Int)
    }
    fun removeItem(position: Int) {
        patientList.removeAt(position)
        notifyItemRemoved(position)
    }
}