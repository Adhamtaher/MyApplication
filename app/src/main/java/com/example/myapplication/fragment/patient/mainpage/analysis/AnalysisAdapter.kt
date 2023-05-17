package com.example.myapplication.fragment.patient.mainpage.analysis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentAnalysisListBinding
import com.example.myapplication.fragment.mainpage.doctors.speciality.AnalysisList

class AnalysisAdapter(private var analysisList: ArrayList<AnalysisList>, val listener: MyClickListener) :
    RecyclerView.Adapter<AnalysisAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentAnalysisListBinding): RecyclerView.ViewHolder(itemBinding.root){

        init {
            itemBinding.root.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }


    }
    fun setFilteredList(analysisList: java.util.ArrayList<AnalysisList>){
        this.analysisList = analysisList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentAnalysisListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return analysisList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.analysisImage.setImageResource(analysisList[position].titleImage)
        holder.itemBinding.analysisName.text = analysisList[position].heading

    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}

