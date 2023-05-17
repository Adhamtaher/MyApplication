package com.example.myapplication.fragment.patient.activity.surgeries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentSurgeriesActivityListBinding

class SurgeriesActivityAdapter(private val surgeriesActivityList: ArrayList<SurgeriesActivityList>, val listener: SurgeriesActivityAdapter.MyClickListener) :
    RecyclerView.Adapter<SurgeriesActivityAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentSurgeriesActivityListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.details.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentSurgeriesActivityListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return surgeriesActivityList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.surImage.setImageResource(surgeriesActivityList[position].titleImage)
        holder.itemBinding.type.text = surgeriesActivityList[position].heading
        holder.itemBinding.date.text = surgeriesActivityList[position].time
        holder.itemBinding.fees.text = surgeriesActivityList[position].fee
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}