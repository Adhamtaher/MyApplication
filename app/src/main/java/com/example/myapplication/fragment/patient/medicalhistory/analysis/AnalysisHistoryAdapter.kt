package com.example.myapplication.fragment.patient.medicalhistory.analysis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentAnalysisHistoryListBinding

class AnalysisHistoryAdapter(private val analysisHistoryList: ArrayList<AnalysisHistoryList>, val listener: MyClickListener) :
    RecyclerView.Adapter<AnalysisHistoryAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentAnalysisHistoryListBinding): RecyclerView.ViewHolder(itemBinding.root){

        init {
            itemBinding.details.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentAnalysisHistoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    }

    override fun getItemCount(): Int {
        return analysisHistoryList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.anaImage.setImageResource(analysisHistoryList[position].titleImage)
        holder.itemBinding.type.text = analysisHistoryList[position].heading
        holder.itemBinding.date.text = analysisHistoryList[position].time
        holder.itemBinding.fees.text = analysisHistoryList[position].fee
    }

    interface MyClickListener{
        fun onClick(position: Int)
    }

}