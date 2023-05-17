package com.example.myapplication.fragment.patient.medicalhistory.radiation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentRadiationHistoryListBinding

class RadiationHistoryAdapter(private val radiationHistoryList: ArrayList<RadiationHistoryList>, val listener: RadiationHistoryAdapter.MyClickListener) :
    RecyclerView.Adapter<RadiationHistoryAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentRadiationHistoryListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.details.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentRadiationHistoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return radiationHistoryList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.radImage.setImageResource(radiationHistoryList[position].titleImage)
        holder.itemBinding.type.text = radiationHistoryList[position].heading
        holder.itemBinding.date.text = radiationHistoryList[position].time
        holder.itemBinding.fees.text = radiationHistoryList[position].fee
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}