package com.example.myapplication.fragment.patient.mainpage.doctors.speciality

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentSpecialtyListBinding

class SpecialityAdapter(private var specialityList: ArrayList<SpecialtyList>, val listener: MyClickListener) :
    RecyclerView.Adapter<SpecialityAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentSpecialtyListBinding): RecyclerView.ViewHolder(itemBinding.root){

        init {
            itemBinding.root.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }


    }
    fun setFilteredList(specialityList: java.util.ArrayList<SpecialtyList>){
        this.specialityList = specialityList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentSpecialtyListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return specialityList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.specialityImage.setImageResource(specialityList[position].titleImage)
        holder.itemBinding.specialityName.text = specialityList[position].heading

    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}

