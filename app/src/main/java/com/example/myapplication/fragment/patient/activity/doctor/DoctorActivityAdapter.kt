package com.example.myapplication.fragment.patient.activity.doctor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentDoctorActivityListBinding
import com.example.myapplication.fragment.doctor.surgeries.SurgeriesAdapter

class DoctorActivityAdapter(private val doctorsActivityList: ArrayList<DoctorActivityList>, val listener: DoctorActivityAdapter.MyClickListener, val onlistener: DoctorActivityAdapter.MyListener) :
    RecyclerView.Adapter<DoctorActivityAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentDoctorActivityListBinding): RecyclerView.ViewHolder(itemBinding.root){
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
        return MyView(FragmentDoctorActivityListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return doctorsActivityList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.doctorImage.setImageResource(doctorsActivityList[position].titleImage)
        holder.itemBinding.doctorName.text = doctorsActivityList[position].heading
        holder.itemBinding.nextvisit.text = doctorsActivityList[position].time
        holder.itemBinding.fees.text = doctorsActivityList[position].fee
        holder.itemBinding.speciality.text = doctorsActivityList[position].spec
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
    interface MyListener{
        fun onDelete(position: Int)
    }
    fun removeItem(position: Int) {
        doctorsActivityList.removeAt(position)
        notifyItemRemoved(position)
    }
}