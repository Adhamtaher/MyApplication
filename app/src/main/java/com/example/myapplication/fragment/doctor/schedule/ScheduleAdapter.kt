package com.example.myapplication.fragment.doctor.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentBookingListBinding
import com.example.myapplication.databinding.FragmentDoctorsListBinding
import com.example.myapplication.databinding.FragmentScheduleListBinding
import com.example.myapplication.fragment.patient.mainpage.doctors.doctors.booking.BookingList

class ScheduleAdapter(private var scheduleList: ArrayList<ScheduleList>, val listener: ScheduleAdapter.MyClickListener) :
    RecyclerView.Adapter<ScheduleAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentScheduleListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.root.setOnClickListener {
                val position = adapterPosition
                listener.onClickSch(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentScheduleListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.appDate.text = scheduleList[position].date
    }
    interface MyClickListener{
        fun onClickSch(position: Int)
    }
}