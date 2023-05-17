package com.example.myapplication.fragment.patient.mainpage.examinations

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
import com.example.myapplication.databinding.FragmentRadiationsBinding
import java.util.ArrayList
import java.util.Locale

class Radiations : Fragment(), RadiationAdapter.MyClickListener {

    lateinit var adapter: RadiationAdapter
    lateinit var radiationList: ArrayList<RadiationList>
    lateinit var searchView: SearchView

    lateinit var imageId: Array<Int>
    lateinit var heading : Array<String>

    private lateinit var binding: FragmentRadiationsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadiationsBinding.inflate(inflater, container, false)
        dataIntialize()
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        adapter = RadiationAdapter(radiationList, this@Radiations)
        binding.recyclerView.adapter = adapter

        binding.searchview.clearFocus()
        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        return binding.root
    }


    private fun filterList(query: String?){
        if (query != null){
            val filteredList = ArrayList<RadiationList>()
            for (i in radiationList){
                if (i.heading.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show()
            }
            else{
                adapter.setFilteredList(filteredList)

            }
        }
    }
    private fun dataIntialize() {
        radiationList = arrayListOf<RadiationList>()
        imageId = arrayOf(
            R.drawable.abdominal,
            R.drawable.bone,
            R.drawable.chest,
            R.drawable.dental,
            R.drawable.joint,
            R.drawable.skull
        )
        heading = arrayOf(
            getString(R.string.rad1),
            getString(R.string.rad2),
            getString(R.string.rad3),
            getString(R.string.rad4),
            getString(R.string.rad5),
            getString(R.string.rad6)
        )
        for (i in imageId.indices) {
            val speciality = RadiationList(imageId[i], heading[i])
            radiationList.add(speciality)
        }
    }
    override fun onClick(position: Int) {
        when(position){
            0-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            1-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            2-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            3-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            4-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            5-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            6-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            7-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            8-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)
            9-> findNavController().navigate(R.id.action_radiations_to_radiationBooking)

        }
    }
}