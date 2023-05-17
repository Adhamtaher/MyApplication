package com.example.myapplication.fragment.patient.mainpage.examinations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentRadiationListBinding
import com.example.myapplication.databinding.FragmentSpecialtyListBinding

class RadiationAdapter(private var radiationList: ArrayList<RadiationList>, val listener: MyClickListener) :
    RecyclerView.Adapter<RadiationAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentRadiationListBinding): RecyclerView.ViewHolder(itemBinding.root){

        init {
            itemBinding.root.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }


    }
    fun setFilteredList(radiationList: java.util.ArrayList<RadiationList>){
        this.radiationList = radiationList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentRadiationListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return radiationList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.radImage.setImageResource(radiationList[position].titleImage)
        holder.itemBinding.radName.text = radiationList[position].heading

    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}

