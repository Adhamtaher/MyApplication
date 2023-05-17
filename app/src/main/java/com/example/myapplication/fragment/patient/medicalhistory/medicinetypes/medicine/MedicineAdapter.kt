package com.example.myapplication.fragment.patient.medicalhistory.medicinetypes.medicine


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentDoctorHistoryListBinding
import com.example.myapplication.databinding.FragmentMedicineListBinding

class MedicineAdapter(private val medicineList: ArrayList<MedicineList>, val listener: MedicineAdapter.MyClickListener) :
    RecyclerView.Adapter<MedicineAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentMedicineListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.addtocart.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentMedicineListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return medicineList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.MedicineImage.setImageResource(medicineList[position].titleImage)
        holder.itemBinding.MedicineName.text = medicineList[position].heading
        holder.itemBinding.priceTag.text = medicineList[position].price
        holder.itemBinding.type.text = medicineList[position].type
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}