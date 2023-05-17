package com.example.myapplication.fragment.doctor.surgeries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentSurgeriesListBinding
import com.example.myapplication.fragment.patient.mainpage.doctors.doctors.DoctorsList


class SurgeriesAdapter(private var surgeriesList: ArrayList<SurgeriesList>, val listener: SurgeriesAdapter.MyClickListener, val onlistener:SurgeriesAdapter.MyListener) :
    RecyclerView.Adapter<SurgeriesAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentSurgeriesListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.cancel.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
            itemBinding.check.setOnClickListener {
                val position = adapterPosition
                onlistener.onClik(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentSurgeriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return surgeriesList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.patientImage.setImageResource(surgeriesList[position].titleImage)
        holder.itemBinding.patientName.text = surgeriesList[position].heading
        holder.itemBinding.visittime.text = surgeriesList[position].time
        holder.itemBinding.lastvisit.text = surgeriesList[position].last
        holder.itemBinding.diagnosis.text = surgeriesList[position].diagnosis
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
    interface MyListener{
        fun onClik(position: Int)
    }
}