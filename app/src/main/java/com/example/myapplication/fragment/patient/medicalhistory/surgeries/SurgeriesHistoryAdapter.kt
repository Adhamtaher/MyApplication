package com.example.myapplication.fragment.patient.medicalhistory.surgeries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentSurgeriesHistoryListBinding

class SurgeriesHistoryAdapter(private val surgeriesHistoryList: ArrayList<SurgeriesHistoryList>, val listener: SurgeriesHistoryAdapter.MyClickListener) :
    RecyclerView.Adapter<SurgeriesHistoryAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentSurgeriesHistoryListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.details.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentSurgeriesHistoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return surgeriesHistoryList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.surImage.setImageResource(surgeriesHistoryList[position].titleImage)
        holder.itemBinding.type.text = surgeriesHistoryList[position].heading
        holder.itemBinding.date.text = surgeriesHistoryList[position].time
        holder.itemBinding.fees.text = surgeriesHistoryList[position].fee
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}