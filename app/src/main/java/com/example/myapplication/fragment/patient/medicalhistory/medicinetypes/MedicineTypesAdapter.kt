package com.example.myapplication.fragment.patient.medicalhistory.medicinetypes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentAnalysisListBinding
import com.example.myapplication.databinding.FragmentMedicineTypesBinding
import com.example.myapplication.databinding.FragmentMedicineTypesListBinding
import com.example.myapplication.fragment.mainpage.doctors.speciality.AnalysisList

class MedicineTypesAdapter(private var medicinetypesList: ArrayList<MedicineTypesList>, val listener: MyClickListener) :
    RecyclerView.Adapter<MedicineTypesAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentMedicineTypesListBinding): RecyclerView.ViewHolder(itemBinding.root){

        init {
            itemBinding.root.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }


    }
    fun setFilteredList(medicinetypesList: java.util.ArrayList<MedicineTypesList>){
        this.medicinetypesList = medicinetypesList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentMedicineTypesListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return medicinetypesList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.medtypeImage.setImageResource(medicinetypesList[position].titleImage)
        holder.itemBinding.medtypeName.text = medicinetypesList[position].heading

    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}

