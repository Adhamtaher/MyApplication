package com.example.myapplication.fragment.patient.mainpage.doctors.doctors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentDoctorsListBinding

class DoctorsAdapter(private var doctorsList: ArrayList<DoctorsList>, val listener: DoctorsAdapter.MyClickListener, val onlistener:DoctorsAdapter.MyListener) :
    RecyclerView.Adapter<DoctorsAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentDoctorsListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.book.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
            itemBinding.available.setOnClickListener {
                val position = adapterPosition
                onlistener.onClik(position)
            }
        }

    }
    fun setFilteredList(doctorsList: ArrayList<DoctorsList>){
        this.doctorsList = doctorsList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentDoctorsListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return doctorsList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.doctorImage.setImageResource(doctorsList[position].titleImage)
        holder.itemBinding.doctorName.text = doctorsList[position].heading
        holder.itemBinding.nextvisit.text = doctorsList[position].time
        holder.itemBinding.fees.text = doctorsList[position].fee
        holder.itemBinding.speciality.text = doctorsList[position].spec
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
    interface MyListener{
        fun onClik(position: Int)
    }
}