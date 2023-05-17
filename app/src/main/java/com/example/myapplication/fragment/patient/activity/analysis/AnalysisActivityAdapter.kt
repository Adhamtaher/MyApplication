package com.example.myapplication.fragment.patient.activity.analysis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentAnalysisActivityListBinding

class AnalysisActivityAdapter(private val analysisActivityList: ArrayList<AnlaysisActivityList>, val listener: AnalysisActivityAdapter.MyClickListener) :
    RecyclerView.Adapter<AnalysisActivityAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentAnalysisActivityListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.details.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentAnalysisActivityListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return analysisActivityList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.anaImage.setImageResource(analysisActivityList[position].titleImage)
        holder.itemBinding.type.text = analysisActivityList[position].heading
        holder.itemBinding.date.text = analysisActivityList[position].time
        holder.itemBinding.fees.text = analysisActivityList[position].fee
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}