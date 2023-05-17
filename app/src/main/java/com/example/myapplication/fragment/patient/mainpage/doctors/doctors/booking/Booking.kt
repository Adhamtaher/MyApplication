package com.example.myapplication.fragment.patient.mainpage.doctors.doctors.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentBookingBinding
import java.util.ArrayList
import java.util.Locale

class Booking : Fragment(), BookingAdapter.MyClickListener {


    lateinit var adapter: BookingAdapter
    lateinit var bookingList: ArrayList<BookingList>

    lateinit var date : Array<String>

    private lateinit var binding: FragmentBookingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingBinding.inflate(inflater, container, false)
        dataIntialize()

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = BookingAdapter(bookingList, this@Booking)
        binding.recyclerView.adapter = adapter


        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        return binding.root
    }
    private fun dataIntialize() {
        bookingList = arrayListOf<BookingList>()
        date = arrayOf(
            getString(R.string.app1),
            getString(R.string.app2),
            getString(R.string.app3),
            getString(R.string.app4),
            getString(R.string.app5),
            getString(R.string.app6),
            )

        for (i in date.indices) {
            val booking = BookingList(date[i])
            bookingList.add(booking)
        }
    }
    override fun onClick(position: Int) {
        when(position){
            0-> findNavController().navigate(R.id.action_booking_to_confirmBooking)
            1-> findNavController().navigate(R.id.action_booking_to_confirmBooking)
            2-> findNavController().navigate(R.id.action_booking_to_confirmBooking)
            3-> findNavController().navigate(R.id.action_booking_to_confirmBooking)
            4-> findNavController().navigate(R.id.action_booking_to_confirmBooking)

        }
    }
}