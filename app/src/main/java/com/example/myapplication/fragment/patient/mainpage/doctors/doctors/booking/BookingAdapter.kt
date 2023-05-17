package com.example.myapplication.fragment.patient.mainpage.doctors.doctors.booking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentBookingListBinding

class BookingAdapter(private var bookingList: ArrayList<BookingList>, val listener: BookingAdapter.MyClickListener) :
    RecyclerView.Adapter<BookingAdapter.MyView>() {

    inner class MyView(val itemBinding: FragmentBookingListBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.book.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(FragmentBookingListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return bookingList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.appDate.text = bookingList[position].date
    }
    interface MyClickListener{
        fun onClick(position: Int)
    }
}