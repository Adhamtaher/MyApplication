package com.example.myapplication.fragment.patient.activity.radiation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentRadiationActivityListBinding

class RadiationActivityAdapter(private val radiationActivityList: ArrayList<RadiationActivityList>, val listener: RadiationActivityAdapter.MyClickListener, val onlistener: RadiationActivityAdapter.MyListener) :
    RecyclerView.Adapter<RadiationActivityAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentRadiationActivityListBinding): RecyclerView.ViewHolder(itemBinding.root){
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
        return MyView(FragmentRadiationActivityListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return radiationActivityList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.radImage.setImageResource(radiationActivityList[position].titleImage)
        holder.itemBinding.type.text = radiationActivityList[position].heading
        holder.itemBinding.date.text = radiationActivityList[position].time
        holder.itemBinding.fees.text = radiationActivityList[position].fee
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
    interface MyListener{
        fun onDelete(position: Int)
    }
    fun removeItem(position: Int) {
        radiationActivityList.removeAt(position)
        notifyItemRemoved(position)
    }
}